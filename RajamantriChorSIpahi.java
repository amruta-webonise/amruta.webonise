public class rajaMantri extends Activity 
{
    
    @Override
    public void onBackPressed() 
    {	
    }
    
    @Override
    protected void onPostResume() 
    {
        // TODO Auto-generated method stub
	super.onPostResume();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) 
    {
        AlertDialog dialog = new AlertDialog.Builder(this).create();
	dialog.setTitle("Exit game!");
	dialog.setMessage("Are you sure you want to exit the game?");
	dialog.setButton("Exit", new DialogInterface.onClickListener() 
	{
	    public void onClick(DialogInterface dialog, int which) 
	    {
	        finish();
	    }
		
	});
	dialog.setButton2("Cancel", new DialogInterface.onClickListener() 
	{	
	    public void onClick(DialogInterface dialog, int which) 
	    {
	        dialog.dismiss();
	    }
	});
	dialog.show();
	return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onLowMemory() 
    {
	AlertDialog dialog = new AlertDialog.Builder(this).create();
	dialog.setTitle("Low memory!");
	dialog.setMessage("Too many apps open, kindly close some other apps and try again!");
	dialog.setButton("Exit", new DialogInterface.onClickListener() 
	{
		public void onClick(DialogInterface dialog, int which) 
		{
			finish();
		}

	});
	dialog.show();
	super.onLowMemory();
    }

    @Override
    protected void onPause() 
    {
	// TODO Auto-generated method stub
	super.onPause();
    }

    String[] solutionArray = { "RAJA", "MANTRI", "CHOR", "SIPAHI"};
    String[] playersArray = {"Player1", "Player2", "Player3", "Player4"};
    static String playerOne_name = "" ;
    static String playerTwo_name = "";
    static String playerThree_name = "";
    static String playerFour_name = "";
    static String playerOne_role = "";
    static String playerTwo_role = "";
    static String playerThree_role = "";
    static String playerFour_role = "";
    static boolean guess = false;
    static String playerOne = "";
    static String playerTwo = "";
    static String playerThree = "";
    static String playerFour = "";
    static int i=0,j=0,k=0,l=0;
    static int pOneScore = 0;
    static int pTwoScore = 0;
    static int pThreeScore = 0;
    static int pFourScore = 0;
    int count = 0;
	
    Button btnRajaMantri;
    Button btnHelp;
    ImageView btn9;
    Button btnPlay;
    static Button btnPod1;
    static Button btnPod2;
    static Button btnPod3;
    static Button btnPod4;
    Button btnShowResult;
    Button btnRestart;
    Button btnSignin;
    Button btnGuess;
    EditText editTxtPlayer1;
    EditText editTxtPlayer2;
    EditText editTxtPlayerThree;
    EditText editTxtPlayerFour;
    EditText edt2;
    EditText edt3;
    EditText edt4;
	
    TextView lblPlayer1;
    TextView lblPlayer2;
    TextView lblPlayer3;
    TextView lblPlayer4;
    static TextView txtTurn;
    static TextView txtPlayer1;
    static TextView txtPlayer2;
    static TextView txtPlayer3;
    static TextView txtPlayer4;
    Bundle savedInstanceState2;
    Button btnMainMenu;
    
    String nextTurn = "";
	
    public void onRestart()
    {
       	super.onRestart();
    }
    
    public void onResume()
    {	
    	super.onResume();	
    }

    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        i = 0;
        j = 0;
        k = 0;
        l = 0;
        btnHelp = (Button)findViewById(R.id.btnHelp);
        btnHelp.setOnClickListener(new OnClickListener() 
        {
	    public void onClick(View v) 
            {
		setContentView(R.layout.help);
		// Create the adView
		AdView adView = new AdView(RajaMantri.this, AdSize.BANNER, "a14e156523d01de");
		// Lookup your LinearLayout assuming it’s been given
		// the attribute android:id="@+id/mainLayout"
		LinearLayout layout = (LinearLayout)findViewById(R.id.mainLayoutHelp);
		// Add the adView to it
		layout.addView(adView);
		// Initiate a generic request to load it with an ad
		adView.loadAd(new AdRequest());
		TextView txtHelp = (TextView)findViewById(R.id.txtHelp);
		String text = "Welcome to nostalgia! This is the paper free version of Raja Mantri Chor Sipahi.\n\nThe game involves bluffing with facial expressions 				       and good guessing. This is a very popular childhood game in India played among kids often during their long summer vacations.\n\nThe game 			       	       has 4 paper chits with Chor (thief), Sipahi (police), Raja (king) and Mantri (minister). The chits are folded at the start of the game 				       and one of the 4 players will press SHUFFLE each one of the four players is supposed to secretly (by taking the phone and not letting the 				       others see it)pick one chit by clicking on it, the player then clicks on the chit again to fold it back. All the players will then 				       secretly open their chits and read what they have got. \n\nThe player who gets the chit with Raja written on it will say MERA MANTRI 				       KAUN? (Who is my minister?). The player who got the chit with Mantri will say MEIN! (Me), The player with Raja will then say CHOR SIPAHI 			       KA PATA LAGAO (find out who is the theif and who is the soldier). The player with Mantri will then guess who is the Chor (Thief), if he 				       is wrong then his points are deducted and if he is correct he gets more points and the points from the player who got Chor (Thief) are 				       deducted.\n\nIf the guess is correct the player with Chor is wrapped on his wrist by the Mantri, and if the Mantri is wrong then the Chor 				       gets to hit his wrist.";
		txtHelp.setText(text);
		Button btnBack = (Button)findViewById(R.id.btnMainMenuHelp);
		btnBack.setOnClickListener(new OnClickListener() 
		{
		    public void onClick(View v) 
		    {
			Intent i = new Intent(RajaMantri.this, RajaMantri.class);
			RajaMantri.this.startActivity(i);
			finish();
		    }
		});
	    }
        });
        btnRajaMantri = (Button) findViewById(R.id.btnRajaMantri);
        btnRajaMantri.setOnClickListener(new OnClickListener() 
        {	
            public void onClick(View v) 
            {
 		// TODO Auto-generated method stub
 		setContentView(R.layout.rmcsp);	
 		// Create the adView
	        AdView adView = new AdView(RajaMantri.this, AdSize.BANNER, "a14e156523d01de");
	        // Lookup your LinearLayout assuming it’s been given
	        // the attribute android:id="@+id/mainLayout"
	        LinearLayout layout = (LinearLayout)findViewById(R.id.mainLayoutPlayer);
	        // Add the adView to it
	        layout.addView(adView);
	        // Initiate a generic request to load it with an ad
	        adView.loadAd(new AdRequest());
	    
 		editTxtPlayerOne = (EditText)findViewById(R.id.editTxtPlayer1);
 		editTxtPlayer2 = (EditText)findViewById(R.id.editTxtPlayer2);
 		editTxtPlayerThree = (EditText)findViewById(R.id.editTxtPlayerThree);
 		editTxtPlayerFour = (EditText)findViewById(R.id.editTxtPlayerFour);
 		
 		lblPlayer1 = (TextView)findViewById(R.id.lblPlayer1);
 		lblPlayer2 = (TextView)findViewById(R.id.lblPlayer2);
 		lblPlayer3 = (TextView)findViewById(R.id.lblPlayer3);
 		lblPlayer4 = (TextView)findViewById(R.id.lblPlayer4);
 		
 		Display display = getWindowManager().getDefaultDisplay(); 
 		int width = display.getWidth();
 		int height = display.getHeight();
 		
 		lblPlayer1.setGravity(Gravity.CENTER_HORIZONTAL);
 		lblPlayer2.setGravity(Gravity.CENTER_HORIZONTAL);
 		lblPlayer3.setGravity(Gravity.CENTER_HORIZONTAL);
 		lblPlayer4.setGravity(Gravity.CENTER_HORIZONTAL);
 		
 		Log.v("AkandBakar", "Playernames:" + playerOne_name);
 		Log.v("AkandBakar", "Playernames:" + playerTwo_name);
 		Log.v("AkandBakar", "Playernames:" + playerThree_name);
 		Log.v("AkandBakar", "Playernames:" + playerFour_name);
 		
 		btnMainMenu =(Button)findViewById(R.id.btnMainMenu);
 		btnMainMenu.setOnClickListener(new onClickListener() 
		{
		    public void onClick(View v) 
		    {
			Intent i = new Intent(RajaMantri.this, RajaMantri.class);
			RajaMantri.this.startActivity(i);
			finish();
		    }
		});
 		
 		btnSignin=(Button)findViewById(R.id.btnsignin);
 		btnSignin.setOnClickListener(new OnClickListener() 
                {
		    public void onClick(View v) 
		    {
			// TODO Auto-generated method stub
			playerOne_name = editTxtPlayerOne.getText().toString();
		 	playerTwo_name = editTxtPlayerTwo.getText().toString();
		 	playerThree_name = editTxtPlayerThree.getText().toString();
		 	playerFour_name = editTxtPlayerFour.getText().toString();
		 		
		 	if(playerOne_name.equals("")||playerTwo_name.equals("")||playerThree_name.equals("")||playerFour_name.equals(""))
			{
			    Toast toast = Toast.makeText(getBaseContext(), "Enter player names!", 8000);
			    toast.show();	
			}
			else
			{
			    setContentView(R.layout.rmcsgnew);	
			    // Create the adView
			    AdView adView = new AdView(RajaMantri.this, AdSize.BANNER, "a14e156523d01de");
			    // Lookup your LinearLayout assuming it’s been given
			    // the attribute android:id="@+id/mainLayout"
			    LinearLayout layout = (LinearLayout)findViewById(R.id.mainLayout);
			    // Add the adView to it
			    layout.addView(adView);
			    // Initiate a generic request to load it with an ad
			    adView.loadAd(new AdRequest());
			    txtTurn = (TextView)findViewById(R.id.txtTurn);
			    txtTurn.setText("Click on SHUFFLE!");
			    playersArray[0] = playerOne_name;
			    playersArray[1] = playerTwo_name;
			    playersArray[2] = playerThree_name;
			    playersArray[3] = playerFour_name;
			 		
			    txtPlayer1=(TextView)findViewById(R.id.txtPlayer1);
			    txtPlayer1.setText("1."+playerOne_name+"[" +pOneScore+ "]");	
			    
			    txtPlayer2=(TextView) findViewById(R.id.txtPlayer2);
			    txtPlayer2.setText("2."+playerTwo_name+ " [" +pTwoScore+ "]");
					
			    txtPlayer3=(TextView)findViewById(R.id.txtPlayer3);
			    txtPlayer3.setText("3."+playerThree_name+ " [" +pThreeScore+ "]");
					
			    txtPlayer4=(TextView) findViewById(R.id.txtPlayer4);
		            txtPlayer4.setText("4."+playerFour_name+ " [" +pFourScore+ "]");
					
			    btnPlay =(Button)findViewById(R.id.btnPlay);
			    btnPlay.setOnClickListener(new onClickListener() 
			    {
	 			public void onClick(View v) 
				{
				    // TODO Auto-generated method stub
				    if(btnPlay.getText().equals("SHUFFLE"))
				    {
				        RajaMantri.this.shuffle();		
		 		    }
				    else
				    {
				        RajaMantri.this.makeGuess();					
		 		        Log.v("RajaMantri", "########## Player Name:" + playerOne_name +" Role:" + playerOne_role);
		 		        Log.v("RajaMantri", "########## Player Name:" + playerTwo_name +" Role:" + playerTwo_role);
		 		        Log.v("RajaMantri", "########## Player Name:" + playerThree_name +" Role:" + playerThree_role);
		 		        Log.v("RajaMantri", "########## Player Name:" + playerFour_name +" Role:" + playerFour_role);
				    }	
		 	        }
		 	   });
			}
		     }
		});
	    }
	});
    }
    
    public void makeGuess()
    {
       	btnPlay.setText("SHUFFLE");
	count = 0;
	btnPlay.setText("SHUFFLE");
	btnPod1.setClickable(true);
	btnPod2.setClickable(true);
	btnPod3.setClickable(true);
	btnPod4.setClickable(true);
		
	if(playerOne.equals("RAJA"))
	{
	    btnPod1.setText("RAJA");
	    btnPod1.setBackgroundResource(R.drawable.podopen);
	    btnPod1.setClickable(false);
	}
	if(playerTwo.equals("RAJA"))
        {
	    btnPod2.setText("RAJA");
	    btnPod2.setBackgroundResource(R.drawable.podopen);
	    btnPod2.setClickable(false);
	}
	if(playerThree.equals("RAJA"))
	{
	    btnPod3.setText("RAJA");
	    btnPod3.setBackgroundResource(R.drawable.podopen);
	    btnPod3.setClickable(false);
	}
	if(playerFour.equals("RAJA"))
	{
	    btnPod4.setText("RAJA");
	    btnPod4.setBackgroundResource(R.drawable.podopen);
	    btnPod4.setClickable(false);
	}
	if(playerOne.equals("MANTRI"))
	{
	    btnPod1.setText("MANTRI");
	    btnPod1.setBackgroundResource(R.drawable.podopen);
	    btnPod1.setClickable(false);
	}
	if(playerTwo.equals("MANTRI"))
	{
	    btnPod2.setText("MANTRI");
	    btnPod2.setBackgroundResource(R.drawable.podopen);
	    btnPod2.setClickable(false);
	}
	if(playerThree.equals("MANTRI"))
	{
	    btnPod3.setText("MANTRI");
	    btnPod3.setBackgroundResource(R.drawable.podopen);
	    btnPod3.setClickable(false);
	}
	if(playerFour.equals("MANTRI"))
	{
	    btnPod4.setText("MANTRI");
	    btnPod4.setBackgroundResource(R.drawable.podopen);
	    btnPod4.setClickable(false);
	}
	if(playerOne_role.equals("MANTRI"))
	{
	    txtTurn.setText(playerOne_name + " will find the CHOR!");
	}
	if(playerTwo_role.equals("MANTRI"))
	{
	    txtTurn.setText(playerTwo_name + " will find the CHOR!");
	}
	if(playerThree_role.equals("MANTRI"))
	{
	    txtTurn.setText(playerThree_name + " will find the CHOR!");
	}
	if(playerFour_role.equals("MANTRI"))
	{
	    txtTurn.setText(playerFour_name + " will find the CHOR!");
	}		
	Log.v("AkhandBakar","#########" +btnPod1.getText());
		
	if(btnPod1.getText().equals(""))
	{
	    btnPod1.setOnClickListener(new OnClickListener() 
	    {
		public void onClick(View v) 
		{
		    // TODO Auto-generated method stub
		    Log.v("AkhandBakar","#########" + playerOne);
		    if(playerOne.equals("CHOR"))
		    {
		        RajaMantri.guess = true;
		        btnPod1.setBackgroundResource(R.drawable.podopen);
		        btnPod1.setText("CHOR");
		    }
		    else
		    {
			RajaMantri.guess = false;
			btnPod1.setBackgroundResource(R.drawable.podopen);
			btnPod1.setText("SIPAHI");
		    }
		    btnPod1.setClickable(false);
		    btnPod2.setClickable(false);
		    btnPod3.setClickable(false);
		    btnPod4.setClickable(false);
		    updateScore();
		}
	    });
	}	
		
	Log.v("AkhandBakar","#########" + btnPod2.getText());
	if(btnPod2.getText().equals(""))
	{
	    btnPod2.setOnClickListener(new OnClickListener() 
	    {
	        public void onClick(View v) 
		{
		    // TODO Auto-generated method stub
		    Log.v("AkhandBakar","#########" + playerTwo);
		    if(playerTwo.equals("CHOR"))
		    {
			RajaMantri.guess = true;
			btnPod2.setBackgroundResource(R.drawable.podopen);
			btnPod2.setText("CHOR");
		    }
		    else
		    {
			RajaMantri.guess = false;
			btnPod2.setBackgroundResource(R.drawable.podopen);
			btnPod2.setText("SIPAHI");
		    }
		    btnPod1.setClickable(false);
		    btnPod2.setClickable(false);
		    btnPod3.setClickable(false);
		    btnPod4.setClickable(false);
		    updateScore();
		}
	    });
	}	
    	
	Log.v("AkhandBakar","#########" + btnPod3.getText());
	if(btnPod3.getText().equals(""))
	{
	    btnPod3.setOnClickListener(new OnClickListener() 
	    {
	        public void onClick(View v) 
		{
		    // TODO Auto-generated method stub
		    Log.v("AkhandBakar","#########" + playerThree);
		    if(playerThree.equals("CHOR"))
		    {
			RajaMantri.guess = true;
			btnPod3.setBackgroundResource(R.drawable.podopen);
			btnPod3.setText("CHOR");
		    }
		    else
		    {
			RajaMantri.guess = false;
			btnPod3.setBackgroundResource(R.drawable.podopen);
			btnPod3.setText("SIPAHI");
		    }
		    btnPod1.setClickable(false);
		    btnPod2.setClickable(false);
		    btnPod3.setClickable(false);
		    btnPod4.setClickable(false);
		    updateScore();
		}
	    });
	}
    	
		
	Log.v("AkhandBakar","#########" + btnPod4.getText());
	if(btnPod4.getText().equals(""))
	{
	    btnPod4.setOnClickListener(new OnClickListener() 
	    {
		public void onClick(View v) 
		{
		    // TODO Auto-generated method stub
		    Log.v("AkhandBakar","#########" + playerFour);
		    if(playerFour.equals("CHOR"))
		    {
			RajaMantri.guess = true;
			btnPod4.setBackgroundResource(R.drawable.podopen);
			btnPod4.setText("CHOR");
		    }
		    else
                    {
			RajaMantri.guess = false;
			btnPod4.setBackgroundResource(R.drawable.podopen);
			btnPod4.setText("SIPAHI");
		    }
		    btnPod1.setClickable(false);
		    btnPod2.setClickable(false);
		    btnPod3.setClickable(false);
		    btnPod4.setClickable(false);
		    updateScore();
		}
	    });
	}	
    }
    
    public void shuffle()
    {
    	btnPlay.setText("Guess");
	btnPlay.setClickable(false);
	shuffleArray(solutionArray);
	txtTurn.setText(playerOne_name + "'s" + " turn!");
	nextTurn = playerTwo_name;
	btnPod1 = (Button)findViewById(R.id.btnPod1);
	btnPod1.setBackgroundResource(R.drawable.podtlclosed);
	btnPod1.setOnClickListener(new OnClickListener() 
	{
	    public void onClick(View v) 
	    {
		// TODO Auto-generated method stub
		playerOne = solutionArray[0];
		btnPod1.setText(playerOne);
		btnPod1.setBackgroundResource(R.drawable.podopen);
		btnPod2.setClickable(false);
		btnPod3.setClickable(false);
		btnPod4.setClickable(false);
		if(txtTurn.getText().equals(playerOne_name + "'s" + " turn!"))
	        {
		    if(playerOne.equals("MANTRI"))
		    {
			playerOne_role = "MANTRI";
		    }
		    if(playerOne.equals("RAJA"))
		    {
			playerOne_role = "RAJA";
		    }
		    if(playerOne.equals("SIPAHI"))
		    {
			playerOne_role = "SIPAHI";
		    }
		    if(playerOne.equals("CHOR"))
		    {
			playerOne_role = "CHOR";	
		    }	    	
		    nextTurn = playerTwo_name + "'s" + " turn!";
						
		}
		if(txtTurn.getText().equals(playerTwo_name + "'s" + " turn!"))
		{
		    if(playerOne.equals("MANTRI"))
		    {
			playerTwo_role = "MANTRI";
		    }
		    if(playerOne.equals("RAJA"))
		    {
			playerTwo_role = "RAJA";
		    }
		    if(playerOne.equals("SIPAHI"))
		    {
			playerTwo_role = "SIPAHI";
		    }
		    if(playerOne.equals("CHOR"))
		    {					
			playerTwo_role = "CHOR";
		    }		    	
		    nextTurn = playerThree_name + "'s" + " turn!";				
		}
		if(txtTurn.getText().equals(playerThree_name + "'s" + " turn!"))
		{
		    if(playerOne.equals("MANTRI"))
		    {
			playerThree_role = "MANTRI";
		    }
		    if(playerOne.equals("RAJA"))
		    {
			playerThree_role = "RAJA";	
		    }
		    if(playerOne.equals("SIPAHI"))
		    {
			playerThree_role = "SIPAHI";
		    }
		    if(playerOne.equals("CHOR"))
		    {
			playerThree_role = "CHOR";
		    }
		    nextTurn = playerFour_name + "'s" + " turn!";
		}
		if(txtTurn.getText().equals(playerFour_name + "'s" + " turn!"))
		{
		    if(playerOne.equals("MANTRI"))
		    {
			playerFour_role = "MANTRI";
		    }
		    if(playerOne.equals("RAJA"))
		    {
		        playerFour_role = "RAJA";
		    }
		    if(playerOne.equals("SIPAHI"))
		    {
			playerFour_role = "SIPAHI";
		    }
		    if(playerOne.equals("CHOR"))
		    {
			playerFour_role = "CHOR";
		    }
		    nextTurn = "Click on Guess!";
		}
					
		txtTurn.setText("Click again to close the chit!");
		btnPod1.setOnClickListener(new OnClickListener() {
						
		public void onClick(View v) 
		{
		    // TODO Auto-generated method stub
		    btnPod1.setClickable(false);
		    count++;
		    btnPod1.setText("");
		    btnPod1.setBackgroundResource(R.drawable.podtlhalf);
		    txtTurn.setText(nextTurn);
		    btnPod2.setClickable(true);
		    btnPod3.setClickable(true);
		    btnPod4.setClickable(true);
		    if(count == 4)
		    {
			txtTurn.setText("Click on Guess!");
			btnPlay.setClickable(true);
			count = 0;
		    }
		}
	    });
	}
    });
			
    btnPod2 = (Button)findViewById(R.id.btnPod2);
    btnPod2.setBackgroundResource(R.drawable.podtrclosed);
    btnPod2.setOnClickListener(new OnClickListener() 
    {
        public void onClick(View v) 
        {
	    // TODO Auto-generated method stub
	    playerTwo = solutionArray[1];
	    btnPod2.setText(playerTwo);
	    btnPod2.setBackgroundResource(R.drawable.podopen);
	    btnPod1.setClickable(false);
	    btnPod3.setClickable(false);
	    btnPod4.setClickable(false);
	    if(txtTurn.getText().equals(playerOne_name + "'s" + " turn!"))
            {
                if(playerTwo.equals("MANTRI"))
                {
                    playerOne_role = "MANTRI";
                }
                if(playerTwo.equals("RAJA"))
                {
                    playerOne_role = "RAJA";
                }
                if(playerTwo.equals("SIPAHI"))
                {
	            playerOne_role = "SIPAHI";
	        }
		if(playerTwo.equals("CHOR"))
                {
		    playerOne_role = "CHOR";
		}
		nextTurn = playerTwo_name+ "'s" + " turn!";
	    }
	    if(txtTurn.getText().equals(playerTwo_name + "'s" + " turn!"))
            {
		if(playerTwo.equals("MANTRI"))
                {
		    playerTwo_role = "MANTRI";
		}
		if(playerTwo.equals("RAJA"))
                {
	            playerTwo_role = "RAJA";
		}
		if(playerTwo.equals("SIPAHI"))
                {
		    playerTwo_role = "SIPAHI";
		}
		if(playerTwo.equals("CHOR"))
		{
		    playerTwo_role = "CHOR";
		}
					    	
		nextTurn = playerThree_name+ "'s" + " turn!";
	    }
	    if(txtTurn.getText().equals(playerThree_name + "'s" + " turn!"))
	    {
		if(playerTwo.equals("MANTRI"))
		{
		    playerThree_role = "MANTRI";
		}
		if(playerTwo.equals("RAJA"))
		{
		    playerThree_role = "RAJA";
		}
		if(playerTwo.equals("SIPAHI"))
		{
		    playerThree_role = "SIPAHI";
		}
		if(playerTwo.equals("CHOR"))
		{
		    playerThree_role = "CHOR";
		}
					    	
		nextTurn = playerFour_name+ "'s" + " turn!";
	    }
	    if(txtTurn.getText().equals(playerFour_name + "'s" + " turn!"))
	    {
		if(playerTwo.equals("MANTRI"))
		{
		    playerFour_role = "MANTRI";
		}
		if(playerTwo.equals("RAJA"))
		{
		    playerFour_role = "RAJA";
		}
		if(playerTwo.equals("SIPAHI"))
		{
		    playerFour_role = "SIPAHI";
		}
		if(playerTwo.equals("CHOR"))
		{
		    playerFour_role = "CHOR";
		}
					    	
		nextTurn = "Click on Guess!";
							
	    }
	    txtTurn.setText("Click again to close the chit!");
	    btnPod2.setOnClickListener(new OnClickListener() 
	    {
		public void onClick(View v) {
		// TODO Auto-generated method stub
		btnPod2.setClickable(false);
		count++;
		btnPod2.setText("");
		btnPod2.setBackgroundResource(R.drawable.podtrhalf);
		txtTurn.setText(nextTurn);
		btnPod1.setClickable(true);
		btnPod3.setClickable(true);
		btnPod4.setClickable(true);
		if(count == 4){
		txtTurn.setText("Click on Guess!");
		btnPlay.setClickable(true);
		count = 0;
		}
		}
		});
	}
	});
		        
	btnPod3 = (Button)findViewById(R.id.btnPod3);
	btnPod3.setBackgroundResource(R.drawable.podblclosed);
	btnPod3.setOnClickListener(new OnClickListener() 
	{
	    public void onClick(View v) 
	    {
	        // TODO Auto-generated method stub
		playerThree = solutionArray[2];
		btnPod3.setText(playerThree);
		btnPod3.setBackgroundResource(R.drawable.podopen);
		btnPod2.setClickable(false);
		btnPod1.setClickable(false);
		btnPod4.setClickable(false);
		if(txtTurn.getText().equals(playerOne_name + "'s" + " turn!"))
		{
		    if(playerThree.equals("MANTRI"))
		    {
			playerOne_role = "MANTRI";
	    	    }
		    if(playerThree.equals("RAJA"))
		    {
			playerOne_role = "RAJA";
		    }
		    if(playerThree.equals("SIPAHI"))
		    {
			playerOne_role = "SIPAHI";
		    }
		    if(playerThree.equals("CHOR"))
		    {
			playerOne_role = "CHOR";
		    }
		    nextTurn = playerTwo_name+ "'s" + " turn!";
		}
	    if(txtTurn.getText().equals(playerTwo_name + "'s" + " turn!"))
	    {
		if(playerThree.equals("MANTRI"))
		{
		    playerTwo_role = "MANTRI";
		}
		if(playerThree.equals("RAJA"))
		{
		    playerTwo_role = "RAJA";
		}
		if(playerThree.equals("SIPAHI"))
		{
		    playerTwo_role = "SIPAHI";
		}
		if(playerThree.equals("CHOR"))
		{
		    playerTwo_role = "CHOR";
		}
		nextTurn = playerThree_name+ "'s" + " turn!";
	    }
	    if(txtTurn.getText().equals(playerThree_name + "'s" + " turn!"))
	    {
		if(playerThree.equals("MANTRI"))
		{
		    playerThree_role = "MANTRI";
		}
		if(playerThree.equals("RAJA"))
		{
		    playerThree_role = "RAJA";
		}
		if(playerThree.equals("SIPAHI"))
		{
		    playerThree_role = "SIPAHI";
		}
		if(playerThree.equals("CHOR"))
		{
		    playerThree_role = "CHOR";
		}
		nextTurn = playerFour_name+ "'s" + " turn!";
	    }
	    if(txtTurn.getText().equals(playerFour_name + "'s" + " turn!"))
	    {
	        if(playerThree.equals("MANTRI"))
		{
		    playerFour_role = "MANTRI";
		}
		if(playerThree.equals("RAJA"))
		{
		    playerFour_role = "RAJA";
		}
		if(playerThree.equals("SIPAHI"))
		{
		    playerFour_role = "SIPAHI";
		}
		if(playerThree.equals("CHOR"))
		{
		    playerFour_role = "CHOR";
		}
		nextTurn = "Click on Guess!";
	    }

	    txtTurn.setText("Click again to close the chit!");
	    btnPod3.setOnClickListener(new OnClickListener() 
	    {
	        public void onClick(View v) 
		{
		    // TODO Auto-generated method stub
		    btnPod3.setClickable(false);
		    count++;
		    btnPod3.setText("");
		    btnPod3.setBackgroundResource(R.drawable.podblhalf);
		    txtTurn.setText(nextTurn);
		    btnPod2.setClickable(true);
		    btnPod1.setClickable(true);
		    btnPod4.setClickable(true);
		    if(count == 4)
		    {
			txtTurn.setText("Click on Guess!");
			btnPlay.setClickable(true);
			count = 0;
		    }
		}
	    });
	}
    });
		     
    btnPod4 = (Button)findViewById(R.id.btnPod4);
    btnPod4.setBackgroundResource(R.drawable.podbrclosed);
    btnPod4.setOnClickListener(new OnClickListener() 
    {
	public void onClick(View v) 
	{
	    // TODO Auto-generated method stub
	    playerFour = solutionArray[3];
    	    btnPod4.setText(playerFour);
	    btnPod4.setBackgroundResource(R.drawable.podopen);
	    btnPod2.setClickable(false);
	    btnPod3.setClickable(false);
	    btnPod1.setClickable(false);
	    if(txtTurn.getText().equals(playerOne_name + "'s" + " turn!"))
	    {
		if(playerFour.equals("MANTRI"))
		{
		    playerOne_role = "MANTRI";
		}
		if(playerFour.equals("RAJA"))
		{
		    playerOne_role = "RAJA";
		}
		if(playerFour.equals("SIPAHI"))
		{
		    playerOne_role = "SIPAHI";
		}
		if(playerFour.equals("CHOR"))
		{
		    playerOne_role = "CHOR";
		}
		nextTurn = playerTwo_name+ "'s" + " turn!";
	    }
	    if(txtTurn.getText().equals(playerTwo_name + "'s" + " turn!"))
	    {
		if(playerFour.equals("MANTRI"))
		{
		    playerTwo_role = "MANTRI";
		}
		if(playerFour.equals("RAJA"))
		{
		    playerTwo_role = "RAJA";
		}
		if(playerFour.equals("SIPAHI"))
		{
		    playerTwo_role = "SIPAHI";
		}
		if(playerFour.equals("CHOR"))
		{
		    playerTwo_role = "CHOR";
		}
		nextTurn = playerThree_name+ "'s" + " turn!";
	    }
	    if(txtTurn.getText().equals(playerThree_name + "'s" + " turn!"))
	    {
		if(playerFour.equals("MANTRI"))
		{
		    playerThree_role = "MANTRI";
		}
		if(playerFour.equals("RAJA"))
		{
		    playerThree_role = "RAJA";
		}
		if(playerFour.equals("SIPAHI"))
		{
		    playerThree_role = "SIPAHI";
		}
		if(playerFour.equals("CHOR"))
		{
		    playerThree_role = "CHOR";
		}
		nextTurn = playerFour_name+ "'s" + " turn!";							
	    }
	}    
    
    public void setRole(String role, String player)
    {
    	if(playerOne.equals("MANTRI"))
	{
	    playerFour_role = "MANTRI";
	}
	if(playerOne.equals("RAJA"))
	{
	    playerFour_role = "RAJA";
	}
	if(playerOne.equals("SIPAHI"))
	{
	    playerFour_role = "SIPAHI";
	}
	if(playerOne.equals("CHOR"))
	{
	    playerFour_role = "CHOR";
	}
     } 
    
    void shuffleArray(String[] solutionArray)
    {
    	Random rnd = new Random();
    	for (int i = solutionArray.length - 1; i >= 0; i--)
    		{
    			int index = rnd.nextInt(i + 1);
  			String a = solutionArray[index];
    			solutionArray[index] = solutionArray[i];
    			solutionArray[i] = a;
    		}
	}
    
    static void updateScore()
    {
    	Log.v("AkhandBakar", "##########"+ guess);
    	if(playerOne_role.equals("MANTRI"))
    	{
	    Log.v("AkhandBakar", "##########Mantri"+ playerOne_name);
    	    if(guess)
    	    {
    	        i = i+80;
    		pOneScore=i;
    		txtTurn.setText(playerOne_name+" is right!");
    		btnPod1.setText(playerOne);
		btnPod2.setText(playerTwo);
		btnPod3.setText(playerThree);
		btnPod4.setText(playerFour);
		btnPod1.setBackgroundResource(R.drawable.podopen);
		btnPod2.setBackgroundResource(R.drawable.podopen);
		btnPod3.setBackgroundResource(R.drawable.podopen);
		btnPod4.setBackgroundResource(R.drawable.podopen);
    		if(playerTwo_role.equals("CHOR"))
    		{
    		    pTwoScore=j;
    		    if(playerThree_role.equals("RAJA"))
		    {
			k = k+100;
			l = l+50;
			pThreeScore=k;
			pFourScore=l;
		    }
                    else
                    {
            		l = l+100;
    			k = k+50;
    			pFourScore=l;
    			pThreeScore=k;
    		    }
    		}
    		if(playerThree_role.equals("CHOR"))
    		{
    		    pThreeScore=k;
    		    if(playerTwo_role.equals("RAJA"))
		    {
    			j = j+100;
    			l = l+50;
    			pTwoScore=j;
    			pFourScore=l;
    		    }
		    else
		    {
    			l = l+100;
    			j = j+50;
    			pFourScore=l;
    			pTwoScore=j;
    		    }
    		}
    		if(playerFour_role.equals("CHOR"))
    		{
    		    pFourScore=l;
    		    if(playerThree_role.equals("RAJA"))
		    {
			k = k+100;
			j = j+50;
			pTwoScore=j;
			pThreeScore=k;
		    }
                    else
                    {
			j = j+100;
			k = k+50;
			pThreeScore=k;
			pTwoScore=j;
		    }
    		}
    	    }
    	    else
    	    {
    		i=i-80;
    		pOneScore = i;
    		txtTurn.setText(playerOne_name+" is wrong!");
    		btnPod1.setText(playerOne);
		btnPod2.setText(playerTwo);
		btnPod3.setText(playerThree);
		btnPod4.setText(playerFour);
		btnPod1.setBackgroundResource(R.drawable.podopen);
		btnPod2.setBackgroundResource(R.drawable.podopen);
		btnPod3.setBackgroundResource(R.drawable.podopen);
		btnPod4.setBackgroundResource(R.drawable.podopen);
		if(playerTwo_role.equals("CHOR"))
		{
		    j = j+25;
		    pTwoScore=j;
		    if(playerThree_role.equals("RAJA"))
		    {
			k = k+100;
			l = l+50;
			pThreeScore=k;
			pFourScore=l;
		    }
                    else
                    {
			l = l+100;
			k = k+50;
			pFourScore=l;
			pThreeScore=k;
		    }
		}
		if(playerThree_role.equals("CHOR"))
		{
		    k=k+25;
		    pThreeScore=k;	
		    if(playerTwo_role.equals("RAJA"))
		    {
			j = j+100;
			l = l+50;
			pTwoScore=j;
			pFourScore=l;
		    }
                    else
                    {
			l = l+100;
			j = j+50;
			pFourScore=l;
			pTwoScore=j;
		    }
		}
		if(playerFour_role.equals("CHOR"))
		{
		    l=l+25;
		    pFourScore=l;
		    
		    if(playerThree_role.equals("RAJA"))
		    {
		        k = k+100;
			j = j+50;
			pTwoScore=j;
			pThreeScore=k;
		    }    
                    else
                    {
			j = j+100;
			k = k+50;
			pThreeScore=k;
			pTwoScore=j;
		    }
		}
    	    }
    	}
        if(playerTwo_role.equals("MANTRI"))
    	{
    	    if(guess)
    	    {
    		Log.v("AkhandBakar", "##########Mantri"+ playerTwo_name);
    		j = j+80;
    		pTwoScore=j;
    		txtTurn.setText(playerTwo_name+" is right!");
    		btnPod1.setText(playerOne);
		btnPod2.setText(playerTwo);
		btnPod3.setText(playerThree);
		btnPod4.setText(playerFour);
		btnPod1.setBackgroundResource(R.drawable.podopen);
		btnPod2.setBackgroundResource(R.drawable.podopen);
		btnPod3.setBackgroundResource(R.drawable.podopen);
		btnPod4.setBackgroundResource(R.drawable.podopen);
    		if(playerOne_role.equals("CHOR"))
    		{
    		    pOneScore=i;
    			
    		    if(playerThree_role.equals("RAJA"))
		    {
    			k = k+100;
    			l = l+50;
    			pThreeScore=k;
    			pFourScore=l;
    		    }
		    else
		    {
			l = l+100;
			k = k+50;
			pFourScore=l;
			pThreeScore=k;
		    }
    			
    		}
    		if(playerThree_role.equals("CHOR"))
    		{
    		    pThreeScore=k;
    		    if(playerOne_role.equals("RAJA"))
		    {
    			i = i+100;
    			l = l+50;
    			pOneScore=i;
    			pFourScore=l;
    		    }
		    else
		    {
    				
    			l = l+100;
    			i = i+50;
    			pOneScore=i;
    			pFourScore=l;	
 		    }    
    			
    		}
    		if(playerFour_role.equals("CHOR"))
    			{
    			
    			pFourScore=l;
    			
    			if(playerOne_role.equals("RAJA")){
    				
    				i = i+100;
    				k = k+50;
    				pOneScore=i;
        			pThreeScore=k;
    				
    			}else{
    				
    				k = k+100;
    				i = i+50;
    				pOneScore=i;
        			pThreeScore=k;
    			
    			
    			}
    			
    			
    			}
    		}
    	else
    		{
    		 
    		j=j-80;
    		pTwoScore = j;
    		txtTurn.setText(playerTwo_name+" is wrong!");
    		btnPod1.setText(playerOne);
			btnPod2.setText(playerTwo);
			btnPod3.setText(playerThree);
			btnPod4.setText(playerFour);
			btnPod1.setBackgroundResource(R.drawable.podopen);
			btnPod2.setBackgroundResource(R.drawable.podopen);
			btnPod3.setBackgroundResource(R.drawable.podopen);
			btnPod4.setBackgroundResource(R.drawable.podopen);
			if(playerOne_role.equals("CHOR"))
			{
				i = i+25;
			pOneScore=i;
			
			if(playerThree_role.equals("RAJA")){
			
				k = k+100;
				l = l+50;
				pThreeScore=k;
				pFourScore=l;
			
			}else{
				
				l = l+100;
				k = k+50;
				pFourScore=l;
				pThreeScore=k;
			}
			
			}
		if(playerThree_role.equals("CHOR"))
			{
			k = k+25;
			pThreeScore=k;
			
			
			if(playerOne_role.equals("RAJA")){
				
				i = i+100;
				l = l+50;
				pOneScore=i;
				pFourScore=l;
				
			}else{
				
				l = l+100;
				i = i+50;
				pOneScore=i;
				pFourScore=l;
				
			}
			
			}
		if(playerFour_role.equals("CHOR"))
			{
			l = l+25;
			pFourScore=l;
			
			if(playerOne_role.equals("RAJA")){
				
				i = i+100;
				k = k+50;
				pOneScore=i;
    			pThreeScore=k;
				
			}else{
				
				k = k+100;
				i = i+50;
				pOneScore=i;
    			pThreeScore=k;
			
			
			}
			
			
			}
    		}

    	}
    if(playerThree_role.equals("MANTRI"))
    	{
    	Log.v("AkhandBakar", "##########Mantri"+ playerThree_name);
    	if(guess)
    		{
    		k = k+80;
    		pThreeScore = k;
    		txtTurn.setText(playerThree_name+" is right!");
    		btnPod1.setText(playerOne);
			btnPod2.setText(playerTwo);
			btnPod3.setText(playerThree);
			btnPod4.setText(playerFour);
			btnPod1.setBackgroundResource(R.drawable.podopen);
			btnPod2.setBackgroundResource(R.drawable.podopen);
			btnPod3.setBackgroundResource(R.drawable.podopen);
			btnPod4.setBackgroundResource(R.drawable.podopen);
    		if(playerOne_role.equals("CHOR"))
    			{
    			pOneScore=i;
    			
    			if(playerTwo_role.equals("RAJA")){
    				
    				j = j+100;
    				l = l+50;
    				pTwoScore=j;
        			pFourScore=l;
        			
    				
    			}else{
    				
    				l = l+100;
    				j = j+50;
    				pTwoScore=j;
        			pFourScore=l;
    				
    				
    			}
    			
    			}
    		if(playerTwo_role.equals("CHOR"))
    			{
    			
    			pTwoScore=j;
    			
    			
    			if(playerOne_role.equals("RAJA")){
    				
    				i = i+100;
    				l = l+50;
    				pOneScore=i;
    				pFourScore=l;
    				
    			}else{
    				
    				i = i+50;
    				l = l+100;
    				pOneScore=i;
    				pFourScore=l;
    				
    			}
    			
    			}
    		if(playerFour_role.equals("CHOR"))
    			{
    			
    			pFourScore=l;
    			
    			if(playerTwo_role.equals("RAJA")){
    				
    				j = j+100;
    				i = i+50;
    				pOneScore=i;
        			pTwoScore=j;
    				
    			}else{
    				
    				j = j+50;
    				i = i+100;
    				pOneScore=i;
        			pTwoScore=j;
    				
    			}
    			
    			
    			}
    		}
    	else
    		{
    		k = k-80;
    		pThreeScore = k;
    		txtTurn.setText(playerThree_name+" is wrong!");
    		btnPod1.setText(playerOne);
			btnPod2.setText(playerTwo);
			btnPod3.setText(playerThree);
			btnPod4.setText(playerFour);
			btnPod1.setBackgroundResource(R.drawable.podopen);
			btnPod2.setBackgroundResource(R.drawable.podopen);
			btnPod3.setBackgroundResource(R.drawable.podopen);
			btnPod4.setBackgroundResource(R.drawable.podopen);
			if(playerOne_role.equals("CHOR"))
			{
				i = i+25;
			pOneScore=i;
			
			if(playerTwo_role.equals("RAJA")){
				
				j = j+100;
				l = l+50;
				pTwoScore=j;
    			pFourScore=l;
    			
				
			}else{
				
				l = l+100;
				j = j+50;
				pTwoScore=j;
    			pFourScore=l;
				
				
			}
			
			}
		if(playerTwo_role.equals("CHOR"))
			{
			j = j+25;
			pTwoScore=j;
			
			
			if(playerOne_role.equals("RAJA")){
				
				i = i+100;
				l = l+50;
				pOneScore=i;
				pFourScore=l;
				
			}else{
				
				i = i+50;
				l = l+100;
				pOneScore=i;
				pFourScore=l;
				
			}
			
			}
		if(playerFour_role.equals("CHOR"))
			{
			l = l+25;
			pFourScore=l;
			
			if(playerTwo_role.equals("RAJA")){
				
				j = j+100;
				i = i+50;
				pOneScore=i;
    			pTwoScore=j;
				
			}else{
				
				j = j+50;
				i = i+100;
				pOneScore=i;
    			pTwoScore=j;
				
			}
			
			
			}
    		}

    	}
    if(playerFour_role.equals("MANTRI"))
    	{
    	Log.v("AkhandBakar", "##########Mantri"+ playerFour_name);
    	if(guess)
    		{
    		l = l+80;
    		pFourScore=l;
    		txtTurn.setText(playerFour_name+" is right!");
    		btnPod1.setText(playerOne);
			btnPod2.setText(playerTwo);
			btnPod3.setText(playerThree);
			btnPod4.setText(playerFour);
			btnPod1.setBackgroundResource(R.drawable.podopen);
			btnPod2.setBackgroundResource(R.drawable.podopen);
			btnPod3.setBackgroundResource(R.drawable.podopen);
			btnPod4.setBackgroundResource(R.drawable.podopen);
    		if(playerOne_role.equals("CHOR"))
    			{
    			pOneScore=i;
    			
    			
    			if(playerTwo_role.equals("RAJA")){
    				
    				j = j+100;
    				k = k+50;
    				pTwoScore=j;
        			pThreeScore=k;
    				
    			}else{
    				
    				j = j+50;
    				k = k+100;
    				pTwoScore=j;
        			pThreeScore=k;
    				
    			}
    			}
    		if(playerTwo_role.equals("CHOR"))
    			{
    			
    			pTwoScore=j;
    			
    			
    			if(playerOne_role.equals("RAJA")){
    				
    				i = i+100;
    				k = k+50;
    				pOneScore=i;
    				pThreeScore=k;
    			}else{
    				
    				i = i+50;
    				k = k+100;
    				pOneScore=i;
    				pThreeScore=k;
    				
    			}
    			
    			}
    		if(playerThree_role.equals("CHOR"))
    			{
    			
    			pThreeScore=k;
    			
    			if(playerOne_role.equals("RAJA")){
    				
    				i = i+100;
    				j = j+50;
    				pOneScore=i;
        			pTwoScore=j;
    			}else{
    				
    				i = i+50;
    				j = j+100;
    				pOneScore=i;
        			pTwoScore=j;
    				
    			}
    			
    			
    			}
    		}
    	else
    		{
    		l = l-80;
    		pFourScore = l;
    		txtTurn.setText(playerFour_name+" is wrong!");
    		btnPod1.setText(playerOne);
			btnPod2.setText(playerTwo);
			btnPod3.setText(playerThree);
			btnPod4.setText(playerFour);
			btnPod1.setBackgroundResource(R.drawable.podopen);
			btnPod2.setBackgroundResource(R.drawable.podopen);
			btnPod3.setBackgroundResource(R.drawable.podopen);
			btnPod4.setBackgroundResource(R.drawable.podopen);
			if(playerOne_role.equals("CHOR"))
			{
				i = i+25;
			pOneScore=i;
			
			
			if(playerTwo_role.equals("RAJA")){
				
				j = j+100;
				k = k+50;
				pTwoScore=j;
    			pThreeScore=k;
				
			}else{
				
				j = j+50;
				k = k+100;
				pTwoScore=j;
    			pThreeScore=k;
				
			}
			}
		if(playerTwo_role.equals("CHOR"))
			{
			j=j+25;
			pTwoScore=j;
			
			
			if(playerOne_role.equals("RAJA")){
				
				i = i+100;
				k = k+50;
				pOneScore=i;
				pThreeScore=k;
			}else{
				
				i = i+50;
				k = k+100;
				pOneScore=i;
				pThreeScore=k;
				
			}
			
			}
		if(playerThree_role.equals("CHOR"))
			{
			k=k+25;
			pThreeScore=k;
			
			if(playerOne_role.equals("RAJA")){
				
				i = i+100;
				j = j+50;
				pOneScore=i;
    			pTwoScore=j;
			}else{
				
				i = i+50;
				j = j+100;
				pOneScore=i;
    			pTwoScore=j;
				
			}
			
			
			}
    		}

    	}
    	
    
    Log.v("AkhandBakar", "##########Score "+ i);
	txtPlayer1.setText("1."+ playerOne_name + " [" + i + "]");
	Log.v("AkhandBakar", playerOne + " [" + i + "]");
	
	txtPlayer2.setText("2." + playerTwo_name+ " [" + j + "]");
	
	Log.v("AkhandBakar", playerTwo + " [" + pTwoScore + "]");
	
	txtPlayer3.setText("3." + playerThree_name+ " [" + k + "]");
	Log.v("AkhandBakar", playerThree + " [" + pThreeScore + "]");
	
	txtPlayer4.setText("4."+playerFour_name+ " [" + l + "]");	
	Log.v("AkhandBakar", playerFour + " [" + pFourScore + "]");
    }
}
