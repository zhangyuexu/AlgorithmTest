
public class KeyboardClickCount {
	public static void main(String[] args){
		String s="HiZyx";
		System.out.println(getKeyboardClickCount(s));
	}
	
	/*
	 * int _tmain(int argc, _TCHAR* argv[])
{
string strtmp;
int n;
cin>>n;
bool flag = false;
int res;
for (int i = 0;i<n;i++)
{
res =0;
flag = false;
cin>>strtmp;
for (int j = 0; j < strtmp.length() ;j++)
{
if (strtmp[j]>= 'a' && strtmp[j]<= 'z' && flag == false)//情况一
{
res++;
}
else
if (strtmp[j]>= 'a' && strtmp[j]<= 'z' && flag == true)//情况二
{
if(j+1<strtmp.length())
{
if (strtmp[j+1]>= 'a' && strtmp[j+1]<= 'z')//状态大写，但字符串连续出现两个小写字母
{
flag = false;//状态切换
res+=2;//切换状态+输入
}
else
res+=2;//shift+字母
}
else
res+=2;


}
else
if (strtmp[j]>= 'A' && strtmp[j]<= 'Z' && flag == true)//情况三
{
res++;
}
else
if (strtmp[j]>= 'A' && strtmp[j]<= 'Z' && flag == false)//情况四
{
if(j+1<strtmp.length())
{
if (strtmp[j+1]>= 'A' && strtmp[j+1]<= 'Z')//状态小写，但字符串连续出现两个大写字母
{
flag = true;//状态切换
res+=2;//切换状态+输入
}
else
res+=2;//shift+字母
}
else
res+=2;
}
}
cout<<res<<endl;
}

return 0;
}

*/	
	public static int getKeyboardClickCount(String s){
		char[] ch=s.toCharArray();
		boolean flag=false;//此时的cap键状态
		int count=0;
		
		for(int i=0;i<ch.length;i++){
			if(flag==false&&Character.isLowerCase(ch[i])){
				count++;
			}
			else if(flag==true&&Character.isLowerCase(ch[i])){
				if((i+1)<ch.length){
					if(Character.isLowerCase(ch[i+1])){
						flag=false;
						count+=2;
					}
					//else{count+=2;}
					if(Character.isUpperCase(ch[i+1])){
						flag=true;
						count+=2;
					}
				}
				else{count+=2;}
			}
			else if(flag==false&&Character.isUpperCase(ch[i])){
				if((i+1)<ch.length){
					if(Character.isUpperCase(ch[i+1])){
						flag=true;
						count+=2;
					}
					//else{count+=2;}
					if(Character.isLowerCase(ch[i+1])){
						flag=false;
						count+=2;
					}
				}
				else{count+=2;}
			}
			else if(flag==true&&Character.isUpperCase(ch[i])){
				count++;
			}
		}
		return count;
	}

}
