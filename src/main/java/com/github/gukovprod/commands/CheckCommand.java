package com.github.gukovprod.commands;

import com.github.gukovprod.BankPosition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

//loomBook
public class CheckCommand implements Command{
    private static final String COMMAND_NAME = "CHECK";

    @Override
    public void execute(String[] args) {
        if (args.length > 0) {

        } else {
            try {
                shortExecute();
            } catch (IOException e) {
                System.out.println("Oops, something went wrong:(");
            }
        }
    }

    protected void shortExecute () throws IOException {
        //TODO Here is my quotes parser
        String url = "https://smart-lab.ru/q/shares/order_by_time/desc/";

        URL quotesURL = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) quotesURL.openConnection();

        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        List<BankPosition> QuotesList = new ArrayList<>();

        String[] bufferedBankPosition = new String[17];
        //0 - индекс
        //1 - время последнего обновления
        //3 - Название
        //7 - Последняя цена
        //9 - Изменение цены
        //11 - Объем
        //12 - Изменение за неделю
        //13 - Изменение за месяц
        //14 - Изменение с начала года
        //15 - Изменение за год
        //16 - Капитализация
        boolean DataStarted = false;
        boolean MassivFilled = false;
        int indexOfQuota = 1;
        int indexForFill = 0;
        while ((inputLine = in.readLine()) != null) {
            if (inputLine.equals("\t\t\t<td>"+indexOfQuota+"</td>")) DataStarted = true;
            if (DataStarted) {
                bufferedBankPosition[indexForFill] = inputLine
                        .replace("<td>","")
                        .replace("</td>","")
                        .replace("<td  class=\"up\">","")
                        .replace("\t","")
                        .replace("<td  class=\"down\">","")
                        .replace("</a>","");
                indexForFill++;
                if (indexForFill == 17) {
                    indexForFill = 0;
                    indexOfQuota++;
                    MassivFilled = true;
                    DataStarted = false;
                }
            }
            if (MassivFilled) {
                QuotesList.add(new BankPosition(bufferedBankPosition[0],
                                                bufferedBankPosition[1],
                                                bufferedBankPosition[3],
                                                bufferedBankPosition[7],
                                                bufferedBankPosition[9],
                                                bufferedBankPosition[11],
                                                bufferedBankPosition[12],
                                                bufferedBankPosition[13],
                                                bufferedBankPosition[14],
                                                bufferedBankPosition[15],
                                                bufferedBankPosition[16]));
                MassivFilled = false;
            }
        }
        in.close();
        for (BankPosition bankPosition : QuotesList) {
            System.out.println(bankPosition.toString());
        }
        //тут сериализуем наш лист объектов и закидываем в файлик
    }

    @Override
    public String getName() {
        return COMMAND_NAME;
    }

    @Override
    public String getFullDescription() {
        return "Lol man, what do you want me to print?.. It's a f@cking list of quotes. That's all!";
    }

    @Override
    public String getShortDescription() {
        return "Prints a list of all possible quotes";
    }
}
