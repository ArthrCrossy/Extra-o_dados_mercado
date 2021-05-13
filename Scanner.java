import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.ArrayList;

import javax.sound.midi.SysexMessage;

public class Scanner{

    private int pos;
    private String Date, sku, sku_category;
    private int id_customer, id_transaction;
    private int quantify;
    private double sales_amout; 

    public Scanner(){
        this.SetPos(0);
        this.SetDate("");
        this.SetSku("");
        this.SetSkuCategory("");
        this.SetCustomer(0);
        this.SetTransaction(0);
        this.SetQuantify(0);
        this.SetSalesAmout(0.0);
    }

    public Scanner(

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

        File arquivo = new File("./scanner_data.csv");

        ArrayList<Scanner> lista = new ArrayList<>();
        ArrayList<Scanner> best_scanner = new ArrayList<>();


        try{
            
            Scanner entrada = new Scanner(arquivo);

            String linha = new String();
            
            entrada.nextLine();

            while(entrada.hasNext()){

            linha = entrada.nextLine();

            String[] valor = linha.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

            Scanner game = new Scanner();

            game.SetPos(Integer.parseInt(valor[0]));
            game.SetDate(valor[1]);
            game.SetCustomer(Integer.parseInt(valor[2]));
            game.SetTransaction(Integer.parseInt(valor[3]));
            game.SetSkuCategory(valor[4]);
            game.SetSku(valor[5]);
            game.SetQuantify(Integer.parseInt(valor[6]));
            game.SetSalesAmout(Double.parseDouble(valor[7]));

            lista.add(game);

            }

        }catch(FileNotFoundException Error){
            System.out.println(Error + "deu ruim");
        }

    }
}