package com.company;
import javax.swing.*;
import java.io.*;
import static java.lang.Math.sqrt;

public class Main
{

    public static void main(String[] args)
    {

        File file = new File("C:\\Users\\Zver\\Desktop\\Input_file.txt");

        try
        {

            FileInputStream StringFile = new FileInputStream(file);
            DataInputStream InBuf = new DataInputStream(StringFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(InBuf));
            String strLine;

            while ((strLine = br.readLine()) != null)
            {
              int K = 0;
              K++;
              System.out.println(strLine);
              String arr = strLine;
              String[] CoordsStr = arr.split(" ");
              int[] Coords = new int[CoordsStr.length];
                for (int i = 0; i < CoordsStr.length; i++)
                {
                    try {
                        Coords[i] = Integer.parseInt(CoordsStr[i]);
                        }
                    catch (NumberFormatException nfe)
                    {  System.err.println("Ошибка в написании координат на линии"+K);}
                }

              if(Coords.length == 6)
                {
                    Double Line1 = SizeLength(Coords[0], Coords[1], Coords[2], Coords[3]);
                    Double Line2 = SizeLength(Coords[2], Coords[3], Coords[4], Coords[5]);
                    Double Line3 = SizeLength(Coords[4], Coords[5], Coords[0], Coords[1]);
                    System.out.println(Line1);
                    System.out.println(Line2);
                    System.out.println(Line3);
                }
              else
                {
                    System.out.println(Coords[5]);
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



    private static double SizeLength (int cord1, int cord2, int cord3, int cord4)
    {
        double x = cord1-cord3;
        double y = cord2-cord4;
        double LengthLine = sqrt(x*x+y*y);
        return LengthLine;
    }

    private static double TriangleSqure (double Length1, double Length2, double Length3)
    {
        Double Perimeter = Length1+Length2+Length3;
        Double Square = sqrt(Perimeter*(Perimeter-Length1)*(Perimeter-Length2)*(Perimeter-Length3));
        return Square;
    }

}


