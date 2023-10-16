/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ma.projet.entity.Produit;
import ma.projet.service.ProduitService;

/**
 *
 * @author HP
 */
public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dateDebut = null;
        Date dateFin = null;
        ProduitService ps = new ProduitService();
        Produit p1 = new Produit("Samsung", "S21", "Smartphone haut de gamme", new Date(), 799.99);
        Produit p2 = new Produit("Apple", "iPhone 13", "Nouveau modèle d'iPhone", new Date(), 999.99);
        Produit p3 = new Produit("Sony", "PlayStation 5", "Console de jeux next-gen", new Date(), 499.99);
        Produit p4 = new Produit("Dell", "XPS 13", "Ordinateur portable ultraportable", new Date(), 1299.99);
        Produit p5 = new Produit("Bose", "SoundLink Mini", "Enceinte Bluetooth compacte", new Date(), 199.99);
        ps.create(p1);
        ps.create(p2);
        ps.create(p3);
        ps.create(p4);
        ps.create(p5);
        for (Produit p : ps.findAll()) {
            System.out.println(p);
        }
        System.out.println(ps.findById(2));
        ps.delete(ps.findById(3));
        Produit pu = ps.findById(1);
         Calendar calendar = Calendar.getInstance();
        calendar.set(2022, Calendar.OCTOBER, 5); // Month is 0-based, so October is 9
        pu.setDate(calendar.getTime());
        ps.update(pu);
        
        for (Produit p : ps.findAll()) {
            if (p.getPrix() > 100) {
                System.out.println(p);
            }
        }
        System.out.print("Entrez la date de début (dd/MM/yyyy) : ");
        try {
            dateDebut = sdf.parse(scanner.next());
        } catch (Exception e) {
            System.out.println("Format de date invalide.");
            return;
        }

        System.out.print("Entrez la date de fin (dd/MM/yyyy) : ");
        try {
            dateFin = sdf.parse(scanner.next());
        } catch (Exception e) {
            System.out.println("Format de date invalide.");
            return;
        }
        for (Produit p : ps.findAll()) {
            if (p.getDate().after(dateDebut) && p.getDate().before(dateFin)) {
                System.out.println(p);
            }
        }
    
    }
}
