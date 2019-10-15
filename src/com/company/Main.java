package com.company;
import java.io.*;
import static java.lang.Math.sqrt;


public class Main {

    public static void main(String[] args) throws IOException {
        int K = 0;
        int ParseFlag;
        double MaxSquare = 0;
        int[] MaxCoords = new int[6];
        File InFile = new File("C:\\Users\\Zver\\Desktop\\Input_file.txt");
        File LogFile = new File("C:\\Users\\Zver\\Desktop\\Log_file.txt");
        File OutFile = new File("C:\\Users\\Zver\\Desktop\\Output_file.txt");

        FileWriter LogWriter = new FileWriter(LogFile);
        FileWriter OutWriter = new FileWriter(OutFile);
        try {
            FileInputStream StringFile = new FileInputStream(InFile);
            DataInputStream InBuf = new DataInputStream(StringFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(InBuf));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                K++;
                ParseFlag = 0;
                String[] CoordsStr = strLine.split(" ");                                                            // разделение строки по пробелу
                int[] Coords = new int[CoordsStr.length];
                for (int i = 0; i < CoordsStr.length; i++)                                                            //парсим строку в числа
                {
                    try {Coords[i] = Integer.parseInt(CoordsStr[i]);}
                    catch (NumberFormatException nfe) {ParseFlag++;}
                }
                if ((Coords.length == 6) && (ParseFlag == 0))
                {
                    Double Line1 = SizeLength1(Coords);
                    Double Line2 = SizeLength2(Coords);
                    Double Line3 = SizeLength3(Coords);
                    if ((Line1.equals(Line2)) || (Line2.equals(Line3)) || (Line3.equals(Line1)))
                        {
                        double s1 = TriangleSqure(Line1, Line2, Line3);
                        if (s1 > MaxSquare)
                            {
                            MaxSquare = s1;
                            for (int i = 0; i < Coords.length; i++) {MaxCoords[i] = Coords[i];}
                            }
                        }
                    else {
                            LogWriter.write("Треугольник не является равноберенным на строке:" + K);
                            LogWriter.write(System.lineSeparator());
                         }
                }
                else
                    {
                        LogWriter.write("Неверное число координат в строке/ошибка в записи координат на строке № " + K);
                        LogWriter.write(System.lineSeparator());
                    }
            }
            InBuf.close();
            } catch (Exception e) {System.err.println("Error");}
        for (int i = 0; i < 6; i++) {OutWriter.write(MaxCoords[i]+" ");}
        LogWriter.flush();
        LogWriter.close();
        OutWriter.flush();
        OutWriter.close();
    }


    private static double SizeLength1(int[] a) {
        double x = a[0] - a[2];
        double y = a[1] - a[3];
        return sqrt(x * x + y * y);
    }

    private static double SizeLength2(int[] a) {
        double x = a[2] - a[4];
        double y = a[3] - a[5];
        return sqrt(x * x + y * y);
    }

    private static double SizeLength3(int[] a) {
        double x = a[4] - a[0];
        double y = a[5] - a[1];
        return sqrt(x * x + y * y);
    }

    private static double TriangleSqure(double Length1, double Length2, double Length3) {
        double Perimeter = Length1 + Length2 + Length3;
        return sqrt(Perimeter * (Perimeter - Length1) * (Perimeter - Length2) * (Perimeter - Length3));
    }
}
