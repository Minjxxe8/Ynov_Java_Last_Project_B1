package fr.ynov.expenses_Gestionnary.domain;
import java.util.HashMap;

public class Debts {
    public HashMap<String, Double> debts;
    public HashMap<String, Double> claims;

    public Debts(){
        this.debts = new HashMap<>();
        this.claims = new HashMap<>();
    }

    // Partie pour gérer les dettes que l'on doit
    public void addDebts(String name, double amount) {
        debts.put(name, debts.getOrDefault(name, 0.0) + amount);
    }

    public void repaysDebts(String name, double amount) {
        if (debts.containsKey(name)) {
            double newDebt = debts.get(name) - amount;
            if (newDebt <= 0) {
                debts.remove(name);
            } else {
                debts.put(name, newDebt);
            }
        }
    }

    public void getAlleDebts() {
        if (debts.isEmpty()) {
            System.out.println("Don't worry, you have no debts hehe");
        } else {
            debts.forEach((name, amount) ->
                    System.out.println(name + ": " + amount + " $")
            );
        }
    }

    public int getDebtsSize() {
        return debts.size();
    }


    //Partie pour gérer les dettes que l'on nous doit
    public void addClaims(String name, double amount) {
        claims.put(name, claims.getOrDefault(name, 0.0) + amount);
    }

    public void getClaims(String name, double amount) {
        if (claims.containsKey(name)) {
            double newClaim = claims.get(name) - amount;
            //Rajouter de l'argent dans notre porte monnaie globale dans Profil
            if (newClaim <= 0) {
                claims.remove(name);
            } else {
                claims.put(name, newClaim);
            }
        }
    }

    public void getAllClaims() {
        if (claims.isEmpty()) {
            System.out.println("No ones have to give you money bro....");
        } else {
            claims.forEach((name, amount) ->
                    System.out.println(name + ": " + amount + " $")
            );
        }
    }
}
