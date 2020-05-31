/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import entities.Departament;
import entities.Worker;
import entities.Enum.WorkerLevel;
import entities.HourContract;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        
        Scanner sc = new Scanner(System.in);
        
        
        System.out.print("Enter departament's name: ");
        String departamentName = sc.nextLine();
        System.out.println("Enter work data:");
        System.out.print("name:");
        String workName = sc.nextLine();
        System.out.print("Level: ");
        String workerLevel = sc.nextLine();
        System.out.print("Base salary:  ");
        Double basesalary = sc.nextDouble();
        System.out.print("How many contract to this worker ? ");
        
        Worker worker = new Worker(workName, WorkerLevel.valueOf(workerLevel), basesalary, new Departament(departamentName));
System.out.print("How many contract to this worckr?  ");
        int n = sc.nextInt();
        
        for (int i = 1; i <=n; i++) {
            System.out.println("Enter contract "+ i +" data");
            System.out.print("Data (DD/MM/YYYY): ");
            Date data = sdf.parse(sc.next());
            System.out.print("Valoue per hours: ");
            Double valuerHouer = sc.nextDouble();
            System.out.print("Duration(hours): ");
            Integer hours = sc.nextInt();
            
            //Apos ter os valores coloco no meu objeto
            HourContract contrats = new HourContract(data, valuerHouer, hours);
           worker.addContract(contrats);
            
        }
        System.out.println();
        System.out.print("Enter month and year to calculate income(MM/YYYY): ");
        String mounthAndYear =sc.next();
        //recortando minha string e passando para o metodo calculador
        int month = Integer.parseInt(mounthAndYear.substring(0,2));
        int year = Integer.parseInt(mounthAndYear.substring(3));
        
        System.out.print("Name"+worker.getName());
        System.out.println();
        System.out.print("Departament"+worker.getDepartament().getName());
        System.out.println();
        System.out.print("Income for "+mounthAndYear+" : "+String.format("%.2f",worker.income(year, month)));
        sc.close();
    }
    
}
