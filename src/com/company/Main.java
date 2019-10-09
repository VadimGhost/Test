package com.company;
import javax.swing.*;
import java.io.*;
import static java.lang.Math.sqrt;


public class Main
{

    public static void main(String[] args)
    {
        int K = 0;
        double MaxSquare = 0;

        File file = new File("C:\\Users\\Zver\\Desktop\\Input_file.txt");
        try
        {

            FileInputStream StringFile = new FileInputStream(file);
            DataInputStream InBuf = new DataInputStream(StringFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(InBuf));
            String strLine;
            while ((strLine = br.readLine()) != null)
                {

                  K++;                                                                                                      // считаем строку по файлу
                  System.out.println(strLine);
                  String arr = strLine;
                  String[] CoordsStr = arr.split(" ");                                                                 // разделение строки по пробелу
                  int[] Coords = new int[CoordsStr.length];
                  for (int i = 0; i < CoordsStr.length; i++)                                                               //парсим строку в числа
                    {
                        try {
                             Coords[i] = Integer.parseInt(CoordsStr[i]);
                            }
                        catch (NumberFormatException nfe)
                            {
                             System.err.println("Ошибка в написании координат на линии"+K);
                            }
                    }

                  if(Coords.length == 6)
                     {
                        Double Line1 = SizeLength1(Coords);
                        Double Line2 = SizeLength2(Coords);
                        Double Line3 = SizeLength3(Coords);

                        if ((Line1.equals(Line2))||(Line2.equals(Line3))||(Line3.equals(Line1)))
                            {
                            double s1 = TriangleSqure(Line1, Line2, Line3);
                            if (s1>MaxSquare)
                            {
//запись максимальных значенний
                            }

                            System.out.println(s1);

                            }
                        else
                            {
                            System.out.println("Треугольник не является равноберенным на строке:"+K);
                             }
                     }
                  else
                    {
                        System.out.println(Coords[5]);
                        System.out.println();
                    }


                    System.out.println(Coords[1]);
                }
            InBuf.close();
        }

        catch (Exception e)
        {
            System.err.println(new JOptionPane ("Error"));
        }
    }



    private static double SizeLength1 (int[] a)
    {
        double x = a[0]-a[2];
        double y = a[1]-a[3];
        return sqrt(x*x+y*y);
    }
    private static double SizeLength2 (int[] a)
    {
        double x = a[2]-a[4];
        double y = a[3]-a[5];
        return sqrt(x*x+y*y);
    }
    private static double SizeLength3 (int[] a)
    {
        double x = a[4]-a[0];
        double y = a[5]-a[1];
        return sqrt(x*x+y*y);
    }

    private static double TriangleSqure (double Length1, double Length2, double Length3)
    {
        double Perimeter = Length1+Length2+Length3;
        return sqrt(Perimeter*(Perimeter-Length1)*(Perimeter-Length2)*(Perimeter-Length3));
    }

}


