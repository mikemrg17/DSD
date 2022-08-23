import java.util.Scanner;

public class programa9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int year;
        String romanYear = "";

        System.out.println("Inserta un año (1 a 3000):");
        do{
            year = input.nextInt();
        }while(year < 1 || year > 3000);

        while(year != 0){
            if(year >= 1000){
                romanYear += "M";
                year -= 1000;
            }else{
                if(year >= 900){
                    romanYear += "CM";
                    year -= 900; 
                }else if(year >= 800){
                    romanYear += "DCCC";
                    year -= 800;
                }else if(year >= 700){
                    romanYear += "DCC";
                    year -= 700;
                }else if(year >= 600){
                    romanYear += "DC";
                    year -= 600;
                }else if(year >= 500){
                    romanYear += "D";
                    year -= 500;
                }else if(year >= 400){
                    romanYear += "CD";
                    year -= 400;
                }else if(year >= 300){
                    romanYear += "CCC";
                    year -= 300;
                }else if(year >= 200){
                    romanYear += "CC";
                    year -= 200;
                }else if(year >= 100){
                    romanYear += "C";
                    year -= 100;
                }else{
                    if(year >= 90){
                        romanYear += "XC";
                        year -= 90;
                    }else if(year >= 80){
                        romanYear += "LXXX";
                        year -= 80;
                    }else if(year >= 70){
                        romanYear += "LXX";
                        year -= 70;
                    }else if(year >= 60){
                        romanYear += "LX";
                        year -= 60;
                    }else if(year >= 50){
                        romanYear += "L";
                        year -= 50;
                    }else if(year >= 40){
                        romanYear += "XL";
                        year -= 40;
                    }else if(year >= 30){
                        romanYear += "XXX";
                        year -= 30;
                    }else if(year >= 20){
                        romanYear += "XX";
                        year -= 20;
                    }else if(year >= 10){
                        romanYear += "X";
                        year -= 10;
                    }else{
                        if(year == 9){
                            romanYear += "IX";
                            year -= 9;
                        }else if(year == 8){
                            romanYear += "VIII";
                            year -= 8;
                        }else if(year == 7){
                            romanYear += "VII";
                            year -= 7;
                        }else if(year == 6){
                            romanYear += "VI";
                            year -= 6;
                        }else if(year == 5){
                            romanYear += "V";
                            year -= 5;
                        }else if(year == 4){
                            romanYear += "IV";
                            year -= 4;
                        }else if(year == 3){
                            romanYear += "III";
                            year -= 3;
                        }else if(year == 2){
                            romanYear += "II";
                            year -= 2;
                        }else{
                            romanYear += "I";
                            year -= 1;
                        }
                    }
                    
                }
            }
        }

        System.out.println("Roman year: " + romanYear);
    }
}