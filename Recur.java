public class Recur extends Program{
public static void main(String[] args) throws Exception{
	 String[] args2={""};
	 String lines[] = new String[10];
	 
	 /* 분리 기호 ; */
	 if(args[0].indexOf(";")>-1){
		lines= args[0].split("\\;"); 

	 /* 분리 기호 , */
	  }else if(args[0].indexOf(",")>-1){
		lines= args[0].split("\\,");

	 /* 분리 기호 carriage return */
	  }else {
		lines= args[0].split("\\r?\\n");
	  }
	 

	 for(int i=0;i<lines.length;i++){

	 args2[0]=lines[i];	
	 Program.main(args2);
	 System.out.println();
	 }
}
}
