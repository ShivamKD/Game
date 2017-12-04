#include <stdio.h>
#include<stdlib.h>

int main() {
	char a[10];
	int win=0;
	char winner[50],player1[50],player2[50];
	int i,t;
	int choice,comp;
	time_t ta;
	srand((unsigned) time(&ta));
	comp=rand()%2;
	printf("Here is the basic version\n\n");
	choice=0;
	a[1]='1';a[2]='2';a[3]='3';a[4]='4';a[5]='5';
	a[6]='6';a[7]='7';a[8]='8';
	a[9]='9';
	printf(" %c | %c | %c \n",a[1],a[2],a[3]);
	printf("___|___|___\n");
	printf(" %c | %c | %c \n",a[4],a[5],a[6]);
	printf("___|___|___\n");
	printf("   |   |   \n");
	printf(" %c | %c | %c \n",a[7],a[8],a[9]);
	
	printf("Lets start the game-Tic Tac Toe\n\n");
	printf("Enter player 1's name-->");
	gets(player1);
	printf("\nEnter player 2's name-->");
	gets(player2);
	
	
	printf("\nSo to avoid a  quarell for the first chance lets do a toss\n");
	printf("\nWe will be spinning the coin which has 2 side- '1' and '0'\n");
	printf("\nPlayer 1->%s will get the change to call for the toss\n",player1);
	printf("\nI guess you know what gonna happen next...\n");
	printf("\nYes! Its the toss time....Press any key to proceed to the toss\n");
	getch();
	//system("cls");
	printf("\n\n%s whats your call '1 or '0'?????\nWrong call may make you loose the toss.\n");
	scanf("%d",&choice);
	
	
	
	printf("%d it is...\n",comp);
	if(comp==choice)
	{
		choice=0;
		printf("%s won the toss\n",player1);
	}
	else
	{
		choice =1;
		printf("Ah! %s you lost the toss...%s you have the first turn now\n",player1,player2);
	}
	
	a[1]=' ';a[2]=' ';a[3]=' ';a[4]=' ';
	a[5]=' ';a[6]=' ';a[7]=' ';a[8]=' ';a[9]=' ';
	//getch();
	printf("So now lets proceed to the game...\n");
	printf("Press any key to continue\n");
	getch();
	for(i=0+choice;i<9+choice;i++)
	{
		system("cls");
			printf(" %c | %c | %c \n",a[1],a[2],a[3]);
	    	printf("___|___|___\n");
	    	printf(" %c | %c | %c \n",a[4],a[5],a[6]);
	    	printf("___|___|___\n");
	    	printf("   |   |   \n");
	   	 	printf(" %c | %c | %c \n",a[7],a[8],a[9]);
	   	 	
		if(i%2==0)
	    printf("Its %s's turn-->\n",player1);
	    else
	    printf("Its %s's turn-->\n",player2);
	    printf("Enter position-->\n");
	    scanf("%d",&t);
	    if(t>=1 && t<=9 && a[t]==' ')
	    {
	    	if((i+choice)%2==0)
	    	a[t]='X';
	    	else
	    	a[t]='0';
			if(a[1]==a[2] && a[2]==a[3] && a[1]!=' ')
			{
				if(a[1]=='X')
				{
					win=1;
					
				}
				else
				{
					win=2;
					
				}
				break;
			}
			if(a[4]==a[5] && a[5]==a[6] && a[4]!=' ')
			{
				if(a[6]=='X')
				{
					win=1;
					
				}
				else
				{
					win=2;
					
				}
				break;
			}
			if(a[7]==a[8] && a[8]==a[9] && a[7]!=' ')
			{
				if(a[9]=='X')
				{
					win=1;
					
				}
				else
				{
					win=2;
					
				}
				break;
			}
			
			if(a[1]==a[4] && a[4]==a[7] && a[7]!=' ')
			{
				if(a[1]=='X')
				{
					win=1;
					
				}
				else
				{
					win=2;
					;
				}
				break;
			}
			
			if(a[5]==a[2] && a[2]==a[8] && a[8]!=' ')
			{
				if(a[2]=='X')
				{
					win=1;
					
				}
				else
				{
					win=2;
					
				}
				break;
			}
			
			if(a[6]==a[9] && a[9]==a[3] && a[3]!=' ')
			{
				if(a[9]=='X')
				{
					win=1;
					
				}
				else
				{
					win=2;
					
				}
				break;
			}
			
			if(a[1]==a[5] && a[5]==a[9] && a[9]!=' ')
			{
				if(a[5]=='X')
				{
					win=1;
					
				}
				else
				{
					win=2;
					
				}
				break;
			}
			
			if(a[5]==a[7] && a[7]==a[3] && a[3]!=' ')
			{
				if(a[7]=='X')
				{
					win=1;
					
				}
				else
				{
					win=2;
					
				}
				break;
			}
			if(i!=8+choice){
		/**	
	    	printf(" %c | %c | %c \n",a[1],a[2],a[3]);
	    	printf("___|___|___\n");
	    	printf(" %c | %c | %c \n",a[4],a[5],a[6]);
	    	printf("___|___|___\n");
	    	printf("   |   |   \n");
	   	 	printf(" %c | %c | %c \n",a[7],a[8],a[9]);
	   	 //	printf("Press any key to continue--\n");
	   	 //	getch();*/
	   	 }
		}
		else
		{
			printf("Termination due to invalid Input:\n");
			printf("Either your position is invalid or the position is already filled up");
			i--;
			printf("Press any key to enter again\n");
			getch();
		//	exit(0);
		}
	}
			printf(" %c | %c | %c \n",a[1],a[2],a[3]);
	    	printf("___|___|___\n");
	    	printf(" %c | %c | %c \n",a[4],a[5],a[6]);
	    	printf("___|___|___\n");
	    	printf("   |   |   \n");
	   	 	printf(" %c | %c | %c \n",a[7],a[8],a[9]);
	if(i+choice!=9)
	{
		if(win!=1)
		printf("%s is winner\n",player1);
		else
		printf("%s is winner\n",player2);
	}
	else
	printf("Match Drawn\n");
	return 0;
}
