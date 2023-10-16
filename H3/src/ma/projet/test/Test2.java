package ma.projet.test;

import java.util.Calendar;
import java.util.Date;
import ma.projet.classes.Employe;
import ma.projet.classes.EmployeTache;
import ma.projet.classes.EmployeTachePK;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.services.EmployeService;
import ma.projet.services.EmployeTacheService;
import ma.projet.services.ProjetService;
import ma.projet.services.TacheService;

public class Test2 {
    public static void main(String[] args) {
        EmployeService es = new EmployeService();
        EmployeTacheService ets = new EmployeTacheService();
        ProjetService ps = new ProjetService();
        TacheService ts = new TacheService();

        // Création des employés
        Employe e1 = new Employe("SULEK", "Sam", "0678583926");
        Employe e2 = new Employe("BUMSTEAD", "Chris", "0616084226");
        es.create(e1);
        es.create(e2);

        // Création d'un projet
        Calendar calendarDebut1 = Calendar.getInstance();
        calendarDebut1.set(2021, Calendar.OCTOBER, 7);
        Calendar calendarDebut2 = Calendar.getInstance();
        calendarDebut2.set(2022, Calendar.AUGUST,29);
        Projet p = new Projet("Finance", calendarDebut1.getTime(), calendarDebut2.getTime(), e2);
        ps.create(p);

        // Création de tâches
        Tache t = new Tache("Bilan", calendarDebut1.getTime(), calendarDebut2.getTime(), 20000, p);
        Tache t2 = new Tache("comptabilite", calendarDebut1.getTime(), calendarDebut2.getTime(), 10000, p);
        ts.create(t);
        ts.create(t2);

        // Attribution des tâches à "SULEK"
        Date dateAttribution = new Date();

        EmployeTachePK employeTachePK1 = new EmployeTachePK(e2.getId(), t.getId(), dateAttribution);
        EmployeTache employeTache1 = new EmployeTache(employeTachePK1);
        ets.create(employeTache1);

        EmployeTachePK employeTachePK2 = new EmployeTachePK(e2.getId(), t2.getId(), dateAttribution);
        EmployeTache employeTache2 = new EmployeTache(employeTachePK2);
        ets.create(employeTache2);

        System.out.println("Tâches assignées à 'SULEK'.");
        es.getTachesRealiseParEmploye(e2);
        es.getProjetsGeresParEmploye(e2);
        System.out.println(p.getId());
        ps.getTachesParProjet(p);
        ps.getTachesCompletes(p);
        System.out.println(t.getDateDebut());
        Date d1 = new Date("2023/12/01");
        Date d2 = new Date("2023/12/05");
        System.out.println(ts.findBetweenDate(d1, d2));
        ts.findBetweenDate(d1, d2).stream().forEach((y) -> {
            System.out.println(y);
        });

    }
}

