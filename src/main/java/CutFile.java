
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/**
 * ʹ���ļ�����ʽ(�������2GB���ϵ�)�������ֶ��������ã�û�а����Ǵ�����ڴ���
 * ʹ���ڴ�ӳ���ļ��Ļ����ٶȻ��һЩ�������ڴ�ӳ������ӳ����ļ����Ȳ��ܳ���java��int���͵����ֵ������ֻ�ܴ���2GB���µ��ļ���
 * @author ASUS
 *
 */
public class CutFile {
	
	public static void mian(String[] args){
		int count=cutFile("D://daily.log.2019-02-01",3000000);
		findStr(count);
	}
	public static int cutFile(String fileName,int size){
		int count=1;
		try{
			BufferedReader bf=new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
			int len;
			char[] ch=new char[size];
			while((len=bf.read(ch, 0, size))!=-1){
				BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName+"_"+count+".txt"),"UTF-8"));
				bw.write(ch, 0, len);
				bw.flush();
				bw.close();
				count++;
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		return count;
	}

	public static void findStr(int count){
		String str="103474142";
		String a1="103474143";
		String a2="service:[smsService],id:[103474144]";
		String a3="103474145";
		for(int i=0;i<=count;i++){
			String fileName="D://daily.log.2019-02-01"+'_'+i+".txt";
			try{
				BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
				String line;
				while((line=br.readLine())!=null){
					if(line.contains(str)||line.contains(a1)||line.contains(a2)||line.contains(a3)){
						System.out.println(fileName);
					}
				}
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}
