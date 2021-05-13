import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Scanner;

import javax.sound.midi.SysexMessage;

public class Scan{

    private int pos;
    private String Date, sku, sku_category;
    private int id_customer, id_transaction;
    private int quantify;
    private double sales_amout; 

    public Scan(){
        this.SetPos(0);
        this.SetDate("");
        this.SetSku("");
        this.SetSkuCategory("");
        this.SetCustomer(0);
        this.SetTransaction(0);
        this.SetQuantify(0);
        this.SetSalesAmout(0.0);
    }

    public Scan(

        int pos,
        String Date,
        String Sku,
        String sku_category,
        int id_customer,
        int id_transaction,
        int quantify,
        double sales_amout
    ){
        this.pos = pos;
        this.Date = Date;
        this.sku = sku;
        this.sku_category = sku_category;
        this.id_customer = id_customer;
        this.id_transaction = id_transaction;
        this.quantify = quantify;
        this.sales_amout = sales_amout;
    }

    public int getPos(){
        return this.pos;
    }

    public int getIdCustomer(){
        return this.id_customer;
    }

    public int getIdTransaction(){
        return this.id_transaction;
    }

    public int getQuantify(){
        return this.quantify;
    }

    public double getSales_amout(){
        return this.sales_amout;
    }

    public String getDate(){
        return this.Date;
    }

    public String getSku(){
        return this.sku;
    }

    public String getSkuCategory(){
        return this.sku_category;
    }

    public void SetPos(int pos){
        this.pos = pos;
    }

    public void SetCustomer(int id_customer){
        this.id_customer = id_customer;
    }

    public void SetTransaction(int id_transaction){
        this.id_transaction = id_transaction;
    }

    public void SetQuantify(int quantify){
        this.quantify = quantify;
    }

    public void SetSalesAmout(double sales_amout){
        this.sales_amout = sales_amout;
    }

    public void SetDate(String date){
        this.Date = date;
    }

    public void SetSku(String sku){
        this.sku = sku;
    }

    public void SetSkuCategory(String sku_category){
        this.sku_category = sku_category;
    }

    public static void main(String[] args){

        File arquivo = new File("./archive/scanner_data.csv");
                                    
        ArrayList<Scan> lista = new ArrayList<>();
        ArrayList<Scan> best_scanner = new ArrayList<>();

        int m = 0;

        try{
            
            Scanner entrada = new Scanner(arquivo);

            String linha = new String();

            entrada.nextLine();

            while(entrada.hasNext()){

            linha = entrada.nextLine();

            String[] valor = linha.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            
            

            Scan game = new Scan();

            game.SetPos(Integer.parseInt(valor[0]));
            game.SetDate(valor[1]);
            game.SetCustomer(Integer.parseInt(valor[2]));
            game.SetTransaction(Integer.parseInt(valor[3]));
            game.SetSkuCategory(valor[4]);
            game.SetSku(valor[5]);
            String tam_quant = valor[6];
            game.SetQuantify(Integer.parseInt(valor[6].replace('.', '1')));
            game.SetSalesAmout(Double.parseDouble(valor[7]));
            lista.add(game);
            }

        }catch(FileNotFoundException Error){
            System.out.println(Error + "deu ruim");
        }

        for(int i = 0; i < lista.size(); i = i + 1){
            best_scanner.add(lista.get(i));
        }

        System.out.println(lista.size());
        

        ArrayList<Scan> aux = new ArrayList<Scan>(best_scanner);
        int tam = best_scanner.size();
        int y = 0;
       
        for(int i = 1; i < tam; i = i + 1){
            aux.set(i, best_scanner.get(i));
            for(y = i - 1; y >= 0 && aux.get(i).getSales_amout() > aux.get(y).getSales_amout(); y = y - 1){
                best_scanner.set(y+1, best_scanner.get(y));
            }
            best_scanner.set(y+1, aux.get(i));
        }


        for(int i = 0; i < 50; i = i + 1){
            System.out.println(best_scanner.get(i).getSales_amout());
        }

    }
}