
//Changed indentation to 4 spaces
public class rajaMantri extends Activity 
{
    //removed unused function onBackPressed
   
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
    String[] playersArray = {"PlayerOne", "PlayerTwo", "PlayerThree", "PlayerFour"};
	//changed player names. As told used One,Two n so on instead of 1,2..
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
	//replaced number by words
    ImageView btnNine;
    Button btnPlay;
    static Button btnPodOne;
    static Button btnPodTwo;
    static Button btnPodThree;
    static Button btnPodFour;
    //created Button temp to use later to reduce redundancy
    Button temp;
    Button btnShowResult;
    Button btnRestart;
    Button btnSignin;
    Button btnGuess;
    EditText editTxtPlayerOne;
    EditText editTxtPlayerTwo;
    EditText editTxtPlayerThree;
    EditText editTxtPlayerFour;
    EditText edt2;
    EditText edt3;
    EditText edt4;
	
    TextView lblPlayerOne;
    TextView lblPlayerTwo;
    TextView lblPlayerThree;
    TextView lblPlayerFour;
    static TextView txtTurn;
    static TextView txtPlayerOne;
    static TextView txtPlayerTwo;
    static TextView txtPlayerThree;
    static TextView txtPlayerFour;
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
	    
 		editTxtPlayerOne = (EditText)findViewById(R.id.editTxtPlayerOne);
 		editTxtPlayerTwo = (EditText)findViewById(R.id.editTxtPlayerTwo);
 		editTxtPlayerThree = (EditText)findViewById(R.id.editTxtPlayerThree);
 		editTxtPlayerFour = (EditText)findViewById(R.id.editTxtPlayerFour);
 		
 		lblPlayerOne = (TextView)findViewById(R.id.lblPlayerOne);
 		lblPlayerTwo = (TextView)findViewById(R.id.lblPlayerTwo);
 		lblPlayerThree = (TextView)findViewById(R.id.lblPlayerThree);
 		lblPlayerFour = (TextView)findViewById(R.id.lblPlayerFour);
 		
 		Display display = getWindowManager().getDefaultDisplay(); 
 		int width = display.getWidth();
 		int height = display.getHeight();
 		
 		lblPlayerOne.setGravity(Gravity.CENTER_HORIZONTAL);
 		lblPlayerTwo.setGravity(Gravity.CENTER_HORIZONTAL);
 		lblPlayerThree.setGravity(Gravity.CENTER_HORIZONTAL);
 		lblPlayerFour.setGravity(Gravity.CENTER_HORIZONTAL);
 		
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
			 		
			    txtPlayerOne=(TextView)findViewById(R.id.txtPlayerOne);
			    txtPlayerOne.setText("1."+playerOne_name+"[" +pOneScore+ "]");	
			    
			    txtPlayerTwo=(TextView) findViewById(R.id.txtPlayerTwo);
			    txtPlayerTwo.setText("2."+playerTwo_name+ " [" +pTwoScore+ "]");
					
			    txtPlayerThree=(TextView)findViewById(R.id.txtPlayerThree);
			    txtPlayerThree.setText("3."+playerThree_name+ " [" +pThreeScore+ "]");
					
			    txtPlayerFour=(TextView) findViewById(R.id.txtPlayerFour);
		            txtPlayerFour.setText("4."+playerFour_name+ " [" +pFourScore+ "]");
					
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
	btnPodOne.setClickable(true);
	btnPodTwo.setClickable(true);
	btnPodThree.setClickable(true);
	btnPodFour.setClickable(true);
		
	if(playerOne.equals("RAJA"))
	{
	//used a different function to set instead of re-writing
	// see A*

	    temp=btnPodOne;
	    temp.setFuncRaja(); //A* called
	}
	if(playerTwo.equals("RAJA"))
        {
	    temp=btnPodTwo;
	    temp.setFuncRaja(); //A* called
	}
	if(playerThree.equals("RAJA"))
	{
	    temp=btnPodThree;
	    temp.setFuncRaja(); //A* called
	}
	if(playerFour.equals("RAJA"))
	{
	    temp=btnPodFour;
	    temp.setFuncRaja(); //A* called
	}
	 
	//used a different function to set instead of re-writing
	// see B*   
	if(playerOne.equals("MANTRI"))
	{
	    temp=btnPodOne;
	    temp.setFuncMantri(); //B* called
	}
	if(playerTwo.equals("MANTRI"))
	{
	    temp=btnPodOne;
	    temp.setFuncMantri(); //B* called
	}
	if(playerThree.equals("MANTRI"))
	{
	    temp=btnPodOne;
	    temp.setFuncMantri(); //B* called
	}
	if(playerFour.equals("MANTRI"))
	{
	    temp=btnPodOne;
	    temp.setFuncMantri(); //B* called
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

// A* added the above fuctionality here so it is re usable
	public void setFuncRaja()
	{
	    btnPodOne.setText("RAJA");
	    btnPodOne.setBackgroundResource(R.drawable.podopen);
	    btnPodOne.setClickable(false);
	}

// B* added the above fuctionality here so it is re usable
	public void setFuncMantri()
	{
	    btnPodOne.setText("MANTRI");
	    btnPodOne.setBackgroundResource(R.drawable.podopen);
	    btnPodOne.setClickable(false);
	}
			
	Log.v("AkhandBakar","#########" +btnPodOne.getText());
		
	if(btnPodOne.getText().equals(""))
	{
	    btnPodOne.setOnClickListener(new OnClickListener() 
	    {
		public void onClick(View v) 
		{
		    // TODO Auto-generated method stub
		    Log.v("AkhandBakar","#########" + playerOne);
		    if(playerOne.equals("CHOR"))
		    {
		        RajaMantri.guess = true;
		        btnPodOne.setBackgroundResource(R.drawable.podopen);
		        btnPodOne.setText("CHOR");
		    }
		    else
		    {
			RajaMantri.guess = false;
			btnPodOne.setBackgroundResource(R.drawable.podopen);
			btnPodOne.setText("SIPAHI");
		    }
		    //writen a different function setClick() instead of writing the same lines again and again. See C*
		    setClick(); //C* called
		}
	    });
	}
		
	Log.v("AkhandBakar","#########" + btnPodTwo.getText());
	if(btnPodTwo.getText().equals(""))
	{
	    btnPodTwo.setOnClickListener(new OnClickListener() 
	    {
	        public void onClick(View v) 
		{
		    // TODO Auto-generated method stub
		    Log.v("AkhandBakar","#########" + playerTwo);
		    if(playerTwo.equals("CHOR"))
		    {
			RajaMantri.guess = true;
			btnPodTwo.setBackgroundResource(R.drawable.podopen);
			btnPodTwo.setText("CHOR");
		    }
		    else
		    {
			RajaMantri.guess = false;
			btnPodTwo.setBackgroundResource(R.drawable.podopen);
			btnPodTwo.setText("SIPAHI");
		    }
		    setClick(); //C* called
		}
	    });
	}	
    	
	Log.v("AkhandBakar","#########" + btnPodThree.getText());
	if(btnPodThree.getText().equals(""))
	{
	    btnPodThree.setOnClickListener(new OnClickListener() 
	    {
	        public void onClick(View v) 
		{
		    // TODO Auto-generated method stub
		    Log.v("AkhandBakar","#########" + playerThree);
		    if(playerThree.equals("CHOR"))
		    {
			RajaMantri.guess = true;
			btnPodThree.setBackgroundResource(R.drawable.podopen);
			btnPodThree.setText("CHOR");
		    }
		    else
		    {
			RajaMantri.guess = false;
			btnPodThree.setBackgroundResource(R.drawable.podopen);
			btnPodThree.setText("SIPAHI");
		    }
		    setClick(); //C* called
		}
	    });
	}
    	
		
	Log.v("AkhandBakar","#########" + btnPodFour.getText());
	if(btnPodFour.getText().equals(""))
	{
	    btnPodFour.setOnClickListener(new OnClickListener() 
	    {
		public void onClick(View v) 
		{
		    // TODO Auto-generated method stub
		    Log.v("AkhandBakar","#########" + playerFour);
		    if(playerFour.equals("CHOR"))
		    {
			RajaMantri.guess = true;
			btnPodFour.setBackgroundResource(R.drawable.podopen);
			btnPodFour.setText("CHOR");
		    }
		    else
                    {
			RajaMantri.guess = false;
			btnPodFour.setBackgroundResource(R.drawable.podopen);
			btnPodFour.setText("SIPAHI");
		    }
		    setClick(); //C* called
		}
	    });
	}

//C* Written the functionality here to be re used
	public void setClick()
	{
	    btnPodOne.setClickable(false);
	    btnPodTwo.setClickable(false);
	    btnPodThree.setClickable(false);
	    btnPodFour.setClickable(false);
	    updateScore();	
	}
    }
    
    public void shuffle()
    {
    	btnPlay.setText("Guess");
	btnPlay.setClickable(false);
	shuffleArray(solutionArray);
	txtTurn.setText(playerOne_name + "'s" + " turn!");
	nextTurn = playerTwo_name;
	btnPodOne = (Button)findViewById(R.id.btnPodOne);
	btnPodOne.setBackgroundResource(R.drawable.podtlclosed);
	btnPodOne.setOnClickListener(new OnClickListener() 
	{
	    public void onClick(View v) 
	    {
		// TODO Auto-generated method stub
		playerOne = solutionArray[0];
		btnPodOne.setText(playerOne);
		btnPodOne.setBackgroundResource(R.drawable.podopen);
		btnPodTwo.setClickable(false);
		btnPodThree.setClickable(false);
		btnPodFour.setClickable(false);
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
		btnPodOne.setOnClickListener(new OnClickListener() {
						
		public void onClick(View v) 
		{
		    // TODO Auto-generated method stub
		    btnPodOne.setClickable(false);
		    count++;
		    btnPodOne.setText("");
		    btnPodOne.setBackgroundResource(R.drawable.podtlhalf);
		    txtTurn.setText(nextTurn);
		    btnPodTwo.setClickable(true);
		    btnPodThree.setClickable(true);
		    btnPodFour.setClickable(true);
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
			
    btnPodTwo = (Button)findViewById(R.id.btnPodTwo);
    btnPodTwo.setBackgroundResource(R.drawable.podtrclosed);
    btnPodTwo.setOnClickListener(new OnClickListener() 
    {
        public void onClick(View v) 
        {
	    // TODO Auto-generated method stub
	    playerTwo = solutionArray[1];
	    btnPodTwo.setText(playerTwo);
	    btnPodTwo.setBackgroundResource(R.drawable.podopen);
	    btnPodOne.setClickable(false);
	    btnPodThree.setClickable(false);
	    btnPodFour.setClickable(false);
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
	    btnPodTwo.setOnClickListener(new OnClickListener() 
	    {
		public void onClick(View v) {
		// TODO Auto-generated method stub
		btnPodTwo.setClickable(false);
		count++;
		btnPodTwo.setText("");
		btnPodTwo.setBackgroundResource(R.drawable.podtrhalf);
		txtTurn.setText(nextTurn);
		btnPodOne.setClickable(true);
		btnPodThree.setClickable(true);
		btnPodFour.setClickable(true);
		if(count == 4){
		txtTurn.setText("Click on Guess!");
		btnPlay.setClickable(true);
		count = 0;
		}
		}
		});
	}
	});
		        
	btnPodThree = (Button)findViewById(R.id.btnPodThree);
	btnPodThree.setBackgroundResource(R.drawable.podblclosed);
	btnPodThree.setOnClickListener(new OnClickListener() 
	{
	    public void onClick(View v) 
	    {
	        // TODO Auto-generated method stub
		playerThree = solutionArray[2];
		btnPodThree.setText(playerThree);
		btnPodThree.setBackgroundResource(R.drawable.podopen);
		btnPodTwo.setClickable(false);
		btnPodOne.setClickable(false);
		btnPodFour.setClickable(false);
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
	    btnPodThree.setOnClickListener(new OnClickListener() 
	    {
	        public void onClick(View v) 
		{
		    // TODO Auto-generated method stub
		    btnPodThree.setClickable(false);
		    count++;
		    btnPodThree.setText("");
		    btnPodThree.setBackgroundResource(R.drawable.podblhalf);
		    txtTurn.setText(nextTurn);
		    btnPodTwo.setClickable(true);
		    btnPodOne.setClickable(true);
		    btnPodFour.setClickable(true);
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
		     
    btnPodFour = (Button)findViewById(R.id.btnPodFour);
    btnPodFour.setBackgroundResource(R.drawable.podbrclosed);
    btnPodFour.setOnClickListener(new OnClickListener() 
    {
	public void onClick(View v) 
	{
	    // TODO Auto-generated method stub
	    playerFour = solutionArray[3];
    	    btnPodFour.setText(playerFour);
	    btnPodFour.setBackgroundResource(R.drawable.podopen);
	    btnPodTwo.setClickable(false);
	    btnPodThree.setClickable(false);
	    btnPodOne.setClickable(false);
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
    		btnPodOne.setText(playerOne);
		btnPodTwo.setText(playerTwo);
		btnPodThree.setText(playerThree);
		btnPodFour.setText(playerFour);
		//Write a function setBackground(). See D*
		setBackground(); //D* called
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
    		btnPodOne.setText(playerOne);
		btnPodTwo.setText(playerTwo);
		btnPodThree.setText(playerThree);
		btnPodFour.setText(playerFour);
		setBackground(); //D* called
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
    		btnPodOne.setText(playerOne);
		btnPodTwo.setText(playerTwo);
		btnPodThree.setText(playerThree);
		btnPodFour.setText(playerFour);
		setBackground(); //D* called
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
    		btnPodOne.setText(playerOne);
			btnPodTwo.setText(playerTwo);
			btnPodThree.setText(playerThree);
			btnPodFour.setText(playerFour);
			setBackground(); //D* called
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
    		btnPodOne.setText(playerOne);
			btnPodTwo.setText(playerTwo);
			btnPodThree.setText(playerThree);
			btnPodFour.setText(playerFour);
			setBackground(); //D* called
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
    		btnPodOne.setText(playerOne);
			btnPodTwo.setText(playerTwo);
			btnPodThree.setText(playerThree);
			btnPodFour.setText(playerFour);
			setBackground(); //D* called
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
    		btnPodOne.setText(playerOne);
			btnPodTwo.setText(playerTwo);
			btnPodThree.setText(playerThree);
			btnPodFour.setText(playerFour);
			setBackground(); //D* called
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
    		btnPodOne.setText(playerOne);
			btnPodTwo.setText(playerTwo);
			btnPodThree.setText(playerThree);
			btnPodFour.setText(playerFour);
			setBackground(); //D* called
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
//D* Functionality written here to re use
	public void setBackground()
	{
	    btnPodOne.setBackgroundResource(R.drawable.podopen);
	    btnPodTwo.setBackgroundResource(R.drawable.podopen);
	    btnPodThree.setBackgroundResource(R.drawable.podopen);
	    btnPodFour.setBackgroundResource(R.drawable.podopen);
    	}
    }
    	
    
    Log.v("AkhandBakar", "##########Score "+ i);
    txtPlayerOne.setText("1."+ playerOne_name + " [" + i + "]");
    Log.v("AkhandBakar", playerOne + " [" + i + "]");
    txtPlayerTwo.setText("2." + playerTwo_name+ " [" + j + "]");
	
    Log.v("AkhandBakar", playerTwo + " [" + pTwoScore + "]");
	
    txtPlayerThree.setText("3." + playerThree_name+ " [" + k + "]");
    Log.v("AkhandBakar", playerThree + " [" + pThreeScore + "]");

    txtPlayerFour.setText("4."+playerFour_name+ " [" + l + "]");	
    Log.v("AkhandBakar", playerFour + " [" + pFourScore + "]");
    }
}
