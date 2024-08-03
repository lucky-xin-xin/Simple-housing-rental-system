//====================================================================房屋出租系统=================================================================================
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class house_rental{
    public static void main(String [] args){
        Gui g=new Gui();
        do{
            g.gui();
        }while(g.a!=6);
    }
}
class Gui{
    Faction f1=new Faction();
    int a;
    Scanner sc=new Scanner(System.in);
    public void gui(){
        System.out.println("--------------------房屋出租系统--------------------");
        System.out.println("        1 新增房源");
        System.out.println("        2 查找房屋");
        System.out.println("        3 删除房屋");
        System.out.println("        4 修改房屋信息");
        System.out.println("        5 房屋列表");
        System.out.println("        6 退出");
        System.out.print("请选择(1-6):");
        a=sc.nextInt();
        switch (a){
            case 1:
                System.out.println("--------------------添加房屋--------------------");
                f1.add();
                break;
            case 2:
                System.out.println("--------------------查找房屋--------------------");
                f1.find();
                break;
            case 3:
                System.out.println("--------------------删除房屋--------------------");
                f1.delete();
                break;
            case 4:
                System.out.println("--------------------修改房屋--------------------");
                f1.change();
                break;
            case 5:
                System.out.println("--------------------房屋列表--------------------");
                f1.list();
                break;
            case 6:
                char choice;
                do{
                    System.out.println("请输入你的选择(y/n):");
                    choice=sc.next().charAt(0);
                    if(choice=='y'){
                        System.out.println("你退出了程序");     
                        a=6;            
                    }else if(choice=='n'){
                        a=0;
                    }
                    else{
                        System.out.print("选择错误，请重新输入:");                   
                    }
                }while(choice != 'y' && choice != 'n');
                break;
            default:
                System.out.println("输入错误，请重新输入:");
                a=0;
                break;
        }
    }
}
class Faction {
    Informaction f[]=new Informaction[100];
    Scanner sc=new Scanner(System.in);
    int i=0;
    public void add(){
        f[i] = new Informaction();
        System.out.print("姓名: ");
        f[i].name=sc.next();
        System.out.print("电话: ");
        f[i].num=sc.next();
        System.out.print("地址: ");
        f[i].address=sc.next();
        System.out.print("月租: ");
        f[i].Mreat=sc.nextDouble();
        System.out.print("状态(未出租/已出租): ");
        f[i].state=sc.next();
        i++;
    }
    public void change(){
        Scanner sc=new Scanner(System.in);
        int bh;
        System.out.print("请选择待修改房间编号(-1退出):");
        bh=sc.nextInt();
        int i=bh-1;
        if(bh!=-1){
            do{
                if(i>=0&&i<f.length){
                    System.out.print("姓名("+f[i].name+"):");
                    f[i].name=sc.next();
                    System.out.print("电话("+f[i].num+"):");
                    f[i].num=sc.next();
                    System.out.print("地址("+f[i].address+"):");
                    f[i].address=sc.next();
                    System.out.print("租金("+f[i].Mreat+"):");
                    f[i].Mreat=sc.nextDouble();
                    System.out.print("状态("+f[i].state+"):");
                    f[i].state=sc.next();
                    System.out.print("-------------------修改完成-------------------");
                }else{
                 System.out.print("范围错误，请重新输入(0~"+f.length+"):");
                }
            }while(!(i>=0&&i<f.length));
        }else{
            System.out.println("已退出");
            return ;
        }

    }
    public void find(){
        Scanner sc=new Scanner(System.in);
        //System.out.println("--------------------查找房屋--------------------");
        System.out.print("请输入你要查找的房间id:");
        int m=sc.nextInt();
        if(f[m-1]==null){
            System.out.println("该编号为null!");
            return ;
        }else{
            System.out.println(m-1+"    "+f[m-1].name+"    "+f[m-1].num+"    "+f[m-1].address+"    "+f[m-1].Mreat+"    "+f[m-1].state);
        }
    }
    public void delete(){
        Scanner sc=new Scanner(System.in);
        System.out.print("请输入待删除房间编号(-1退出):");
        int a=sc.nextInt();
        if(a==-1){
            System.out.println("--------------------退出--------------------");
            return ;
        }else{
            char choice;
            do{
                System.out.print("确认是否删除(y/n):");
                choice =sc.next().charAt(0);
                if(choice=='y')
                {
                    f[a-1]=null;
                    System.out.println("删除成功!");
                    return ;
                }
                else if(choice=='n'){
                    System.out.println("--------------------退出--------------------");
                    return ;
                }
                else{
                    System.out.println("输入错误!");
                }
            }while(choice!='y'||choice!='n');
        }

    }
    public void list(){
        int i=0;
        System.out.println("编号    房主    电话    地址    月租    状态(已出租/未出租)");
        while(f[i]!=null){
            System.out.println(i+"    "+f[i].name+"    "+f[i].num+"    "+f[i].address+"    "+f[i].Mreat+"    "+f[i].state);
            i++;
        }
    }

}
class Informaction{
    String name;
    String num;
    String address;
    double Mreat;
    String state;
}
//===========================================================================OVER====================================================================================