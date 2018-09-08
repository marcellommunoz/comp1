import java.io.*;

enum TokenType{ NUM,SOMA, MULT, DIV, SUB,APar,FPar, EOF}

class Token{
  String lexema;
  TokenType token;

 Token (String l, TokenType t)
 	{ lexema=l;token = t;}	

}

class AnaliseLexica {

	BufferedReader arquivo;

	AnaliseLexica(String a) throws Exception
	{
		
	 	this.arquivo = new BufferedReader(new FileReader(a));
		
	}

	Token getNextToken() throws Exception
	{	
		Token token;
		int eof = -1;
		char currchar;
		int currchar1;

			do{
				currchar1 =  arquivo.read();
				currchar = (char) currchar1;
			} while (currchar == '\n' || currchar == ' ' || currchar =='\t' || currchar == '\r');
			
			if(currchar1 != eof && currchar1 !=10)
			{
				if (currchar >= '0' && currchar <= '9'){
					int num = Integer.valueOf(String.valueOf(currchar));
					arquivo.mark(1);
					currchar1 = arquivo.read();
					currchar = (char) currchar1;
					if(!(currchar >= '0' && currchar <= '9')){
						arquivo.reset();
					}
					while (currchar >= '0' && currchar <= '9'){
						num = num*10 + Integer.valueOf(String.valueOf(currchar));
						arquivo.mark(1);
						currchar1 = arquivo.read();
						currchar = (char) currchar1;
						if(!(currchar >= '0' && currchar <= '9')){
							arquivo.reset();
						}
					}
					return (new Token (String.valueOf(num), TokenType.NUM));
					//return (new Token (currchar, TokenType.NUM));
				}
				else
					switch (currchar){
						case '(':
							//return (new Token (currchar,TokenType.APar));
							return (new Token (String.valueOf(currchar),TokenType.APar));
						case ')':
							return (new Token (String.valueOf(currchar),TokenType.FPar));
							//return (new Token (currchar,TokenType.FPar));
						case '+':
							return (new Token (String.valueOf(currchar),TokenType.SOMA));
							//return (new Token (currchar,TokenType.SOMA));
						case '*':
							return (new Token (String.valueOf(currchar),TokenType.MULT));
							//return (new Token (currchar,TokenType.MULT));
						case '/':
							return (new Token (String.valueOf(currchar),TokenType.DIV));
							//return (new Token (currchar,TokenType.DIV));
						case '-':
							return (new Token (String.valueOf(currchar),TokenType.SUB));
							//return (new Token (currchar,TokenType.SUB));
						
						default: throw (new Exception("Caractere inválido: " + ((int) currchar)));
					}
			}

			arquivo.close();

		return (new Token(String.valueOf(currchar),TokenType.EOF));
		//return (new Token(currchar,TokenType.EOF));
	}
}
