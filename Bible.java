package taebu;

public class Bible extends Valiables
{
	public static void main(String[] args) throws Exception
	{
		String[] tempStrings = new String[1];
		String[] commaArgs;
		if (args.length == 1&&args[0].indexOf(",")>-1) {
			commaArgs = args[0].split(",");

			for (int i =0;i<commaArgs.length ; i++) {
				tempStrings[0]= commaArgs[i];
				new Functions(tempStrings);
			}
			System.exit(0);

		}else if(args.length == 1)
		{	
			new Functions(args);
		}else if(args.length>1){
			for (int i =0;i<args.length ; i++) {
				tempStrings[0]= args[i];
				new Functions(tempStrings);
			}
		}
    }
}
