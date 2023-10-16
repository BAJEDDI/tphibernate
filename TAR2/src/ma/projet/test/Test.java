/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Date;
import ma.projet.beans.Femme;
import ma.projet.beans.Homme;
import ma.projet.beans.Mariage;
import ma.projet.beans.MariagePK;
import ma.projet.services.FemmeService;
import ma.projet.services.HommeService;
import ma.projet.services.MariageService;
import ma.projet.util.HibernateUtil;

/**
 *
 * @author HP
 */
public class Test {

    public static void main(String[] args) {
        FemmeService fs = new FemmeService();
        HommeService hs = new HommeService();
        MariageService ms = new MariageService();
        //1==========================
        Femme f1 = new Femme("lmrini", "hajar", "0678986352", "Casablanca", new Date("1965/08/05"));
        Femme f2 = new Femme("belfqir", "nada", "0614598756", "El Jadida", new Date("1994/12/25"));
        Femme f3 = new Femme("alaoui", "maria", "0614785962", "Marrakech", new Date("1980/08/29"));
        Femme f4 = new Femme("nakir", "hakima", "0688951234", "Safi", new Date("2000/04/17"));
        Femme f5 = new Femme("haoudi", "manal", "0659746638", "Agadir", new Date("1972/11/30"));
        Femme f6 = new Femme("jahidi", "naima", "0692598633", "Sale", new Date("1978/07/05"));
        Femme f7 = new Femme("kissani", "zineb", "0644795802", "Tanger", new Date("1988/07/01"));
        Femme f8 = new Femme("kaissoun", "nawal", "0617459321", "Fes", new Date("2000/02/26"));
        Femme f9 = new Femme("alami", "sara", "0608093745", "khenifra", new Date("1985/08/12"));
        Femme f10 = new Femme("raqy", "jihane", "0607895100", "Taza", new Date("1999/11/13"));

        Homme h1 = new Homme("lamar", "ken", "0678596328", "Marrakech", new Date("1962/08/13"));
        Homme h2 = new Homme("alioui", "jamal", "0602364910", "Rabat", new Date("1972/12/29"));
        Homme h3 = new Homme("jamali", "laarbi", "0617293865", "Rabat", new Date("1964/11/22"));
        Homme h4 = new Homme("fatmi", "hamid", "0645821312", "Oujda", new Date("1995/10/22"));
        Homme h5 = new Homme("mnawar", "chakir", "0641102583", "laayoune", new Date("1993/02/14"));

        fs.create(f1);
        fs.create(f2);
        fs.create(f3);
        fs.create(f4);
        fs.create(f5);
        fs.create(f6);
        fs.create(f7);
        fs.create(f8);
        fs.create(f9);
        fs.create(f10);

        hs.create(h1);
        hs.create(h2);
        hs.create(h3);
        hs.create(h4);
        hs.create(h5);

        MariagePK mpk1 = new MariagePK(1, 12, new Date("2022/12/09"));
        MariagePK mpk2 = new MariagePK(5, 13, new Date("2021/10/09"));
        MariagePK mpk3 = new MariagePK(6, 14, new Date("2021/11/22"));
        MariagePK mpk4 = new MariagePK(2, 11, new Date("2017/07/07"));
        MariagePK mpk5 = new MariagePK(4, 11, new Date("2023/07/04"));
        MariagePK mpk6 = new MariagePK(7, 11, new Date("2019/03/08"));
        MariagePK mpk7 = new MariagePK(9, 11, new Date("2020/01/08"));

        Mariage m1 = new Mariage(mpk1, null, 3);
        Mariage m2 = new Mariage(mpk2, new Date("2022/07/21"), 1);
        Mariage m3 = new Mariage(mpk3, null, 3);
        Mariage m4 = new Mariage(mpk4, new Date("2023/12/12"), 2);
        Mariage m5 = new Mariage(mpk5, new Date("2019/02/01"), 4);
        Mariage m6 = new Mariage(mpk6, new Date("2023/10/01"), 3);
        Mariage m7 = new Mariage(mpk7, new Date("2021/11/23"), 3);

        ms.create(m1);
        ms.create(m2);
        ms.create(m3);
        ms.create(m4);
        ms.create(m5);
        ms.create(m6);
        ms.create(m7);

//2================
        for (Femme ff : fs.getAll()) {
            System.out.println(ff);
        }
//3=================
        System.out.println(fs.getFemmeLaPlusAgee().getNom());
//4============================
        HommeService.getEpousesParHomme(hs.getById(13));
        //5=========================
        System.out.println(fs.getNbrEnfantsEntreDates(2, new Date("2018/08/12"), new Date("2023/08/12")));
        //6==========================
        for (Femme fem : fs.getFemmesMarieesDeuxFoisOuPlus()) {
            System.out.println(fem);
        }
//7========================
        hs.afficherHommeMarieParQtrEntreDates(new Date("2000/01/01"), new Date("2024/01/01"));
//8=========================
        for (Mariage m : hs.getMariagesParHomme(hs.getById(11))) {
            System.out.println(m);
        }
    }
}
