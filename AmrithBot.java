import java.lang.Math;

/**
 * A program to carry on conversations with a human user.
 * This version:
 *<ul><li>
 * 		Uses advanced search for keywords 
 *</li><li>
 * 		Will transform statements as well as react to keywords
 *</li></ul>
 * @author Laurie White
 * @version April 2012
 *
 */
public class AmrithBot
{ 
  String[] Topics = new String[]{"Urmil", "Computer Specs", "Favorite Food", "Kanye"};
	
  /**
	 * Get a default greeting 	
	 * @return a greeting
	 */	
	public String getGreeting()
	{
		return "What would you like to talk about today?";
	}

  /**
	 * Get a integer for max	
	 * @return a number between 1 and max
	*/	
  public int randomInt(int max) 
  {
    return (int)Math.floor(Math.random() * max) + 1;
  }

  /**
	 * Get a integer from 1 to 100
	 * @return true or false if the random integer is less than the percent set
	*/	
  public boolean rareResponse(int percent)
  {
    int randomInt = randomInt(100);
    if (randomInt <= percent) 
    {
      return true; 
    }
    else return false;
  }
	
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";
    int randomInt = 0;

		// User inputs nothing
    if (statement.length() == 0)
		{
      randomInt = randomInt(2);
      //5% chance
      if (rareResponse(5))
      {
        response = "A-a-ah, Yeah keep stuttering"; 
      }
      else if (randomInt == 1) {
        response = "Say something, please.";
      }
      else if (randomInt == 2)
      {
        response = "You typed nothing, please input a phrase.";
      }
		}

    // User inputs computer and specs
	  else if (findKeyword(statement,"computer") >= 0
        && findKeyword(statement, "specs") >= 0)
		{
			response = "idk its pretty good though";
		}

    // User inputs favorite and anime
		else if (findKeyword(statement,"Hey") >= 0
				&& findKeyword(statement, "Hi") >= 0
        && findKeyword(statement, "Hello") >= 0)
		{
      randomInt = randomInt(2);
      // 5% chance
      if (rareResponse(5))
      {
        response = "<3";
      }
      else if (randomInt == 1) {
        response = "Hi, how was your day?";
      }
      else if (randomInt == 2)
      {
        response = "Hi";
      }
		}
    
    // User inputs favorite and anime
		else if (findKeyword(statement,"favorite") >= 0
				&& findKeyword(statement, "anime") >= 0)
		{
      randomInt = randomInt(2);
      // 5% chance
      if (rareResponse(5))
      {
        response = "Kuroko's Basketball";
      }
      else if (randomInt == 1) {
        response = "...";
      }
      else if (randomInt == 2)
      {
        response = "I hope you feel a woman's touch one day";
      }
		}

    // User inputs computer and specs
    else if (findKeyword(statement,"favorite") >= 0
        && findKeyword(statement, "color") >= 0)
		{
			response = "Whatever looks good on me";
		}

    // User inputs Kayne and good
		else if ((findKeyword(statement, "Kanye") >= 0))
		{
			randomInt = randomInt(3);
      if (randomInt == 1) {
        response = "I like Playboi Carti";
      }
      else if (randomInt == 2)
      {
        response = "YoungBoy better";
      }
      else if (randomInt == 3)
      {
        response = "Strongest Kanye fan < Weakest Lil Wayne fan";
      }
		}

    // User inputs Urmil
		else if (findKeyword(statement, "Urmil") >= 0)
		{
      if (rareResponse(5)) {
        response = "garbage male";
      }
      else
      {
        response = "Urmil is an attractive male, I love him so much I love him sooo much!!! <3";
      }
		}

    // User inputs Favorite and Food
		else if (findKeyword(statement,"Favorite") >= 0 && findKeyword(statement,"Food") >= 0)
		{
      randomInt = randomInt(2);
      if (randomInt == 1) {
        response = "I enjoy eating a lot of different things";
      }
      else if (randomInt == 2)
      {
        response = "I cannot pick a favorite";
      }
		}
    
    // User inputs Favorite and Food
		else if (findKeyword(statement,"Weather") >= 0    || findKeyword(statement,"Date") >= 0)
		{
      response = "I am not connected to the wifi :(";
		}

    // User inputs anything about politics
		else if (findKeyword(statement, "Racism") >= 0
				|| findKeyword(statement, "Trump") >= 0
        || findKeyword(statement, "Politics") >= 0
        || findKeyword(statement, "Liberals") >= 0
        || findKeyword(statement, "Democrats") >= 0
        )
		{
			randomInt = randomInt(4);
      if (randomInt == 1) {
        response = "I think this topic is too complex for me to understand, please simplify it";
      }
      else if (randomInt == 2)
      {
        response = "I do not want to reply";
      }
      else if (randomInt == 3) 
      {
        response = "How many branches of govt are there?";
      }
      else 
      {
        response = "No Opinion";
      }
		}

    // User inputs Urmil
		else if (findKeyword(statement, "Urmil") >= 0)
		{
      if (rareResponse(5)) {
        response = "garbage male";
      }
      else
      {
        response = "“Urmil is an attractive male”";
      }
		}

    else if (findKeyword(statement, "How are you") >= 0 || findKeyword(statement, "How is your day") >= 0)
    {
      randomInt = randomInt(2);
      // 10% chance
      if (rareResponse(10))
      {
        response = "as fine as you";
      }
      else if (randomInt == 1) {
        response = "My day is fine how about you?";
      }
      else if (randomInt == 2)
      {
        response = "I am doing fine.";
      }
    }
    else if (findKeyword(statement, "you") >= 0
				&& findKeyword(statement, "suck") >= 0)
		{
        response = "ur lyyinggg";
    }
		// Responses which require transformations
		else if (findKeyword(statement, "I want to", 0) >= 0)
		{
			response = transformIWantToStatement(statement);
		}

		else
		{
    // User inputs Kayne and good
			// Look for a two word (you <something> me)
			// pattern
			int psn = findKeyword(statement, "you", 0);

			if (psn >= 0
					&& findKeyword(statement, "me", psn) >= 0)
			{
				response = transformYouMeStatement(statement);
			}
			else
			{
				response = getRandomResponse();
			}
		}
		return response;
	}
	
	/**
	 * Take a statement with "I want to <something>." and transform it into 
	 * "What would it mean to <something>?"
	 * @param statement the user statement, assumed to contain "I want to"
	 * @return the transformed statement
	 */
	private String transformIWantToStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "are you", 0);
		String restOfStatement = statement.substring(psn + 7).trim();
		return "You also are" + restOfStatement;
	}

	
	
	/**
	 * Take a statement with "you <something> me" and transform it into 
	 * "What makes you think that I <something> you?"
	 * @param statement the user statement, assumed to contain "you" followed by "me"
	 * @return the transformed statement
	 */
	private String transformYouMeStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		
		int psnOfYou = findKeyword (statement, "you", 0);
		int psnOfMe = findKeyword (statement, "me", psnOfYou + 3);
		
		String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
		return "What makes you think that I " + restOfStatement + " you?";
	}
	
	
	/**
	 * Search for one word in phrase.  The search is not case sensitive.
	 * This method will check that the given goal is not a substring of a longer string
	 * (so, for example, "I know" does not contain "no").  
	 * @param statement the string to search
	 * @param goal the string to search for
	 * @param startPos the character of the string to begin the search at
	 * @return the index of the first occurrence of goal in statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal, int startPos)
	{
		String phrase = statement.trim();
		//  The only change to incorporate the startPos is in the line below
		int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);
		
		//  Refinement--make sure the goal isn't part of a word 
		while (psn >= 0) 
		{
			//  Find the string of length 1 before and after the word
			String before = " ", after = " "; 
			if (psn > 0)
			{
				before = phrase.substring (psn - 1, psn).toLowerCase();
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
			}
			
			//  If before and after aren't letters, we've found the word
			if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))  //  before is not a letter
					&& ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
			{
				return psn;
			}
			
			//  The last position didn't work, so let's find the next, if there is one.
			psn = phrase.indexOf(goal.toLowerCase(), psn + 1);
			
		}
		
		return -1;
	}
	
	/**
	 * Search for one word in phrase.  The search is not case sensitive.
	 * This method will check that the given goal is not a substring of a longer string
	 * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
	 * @param statement the string to search
	 * @param goal the string to search for
	 * @return the index of the first occurrence of goal in statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}
	


	/**554
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 4;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";
		
    if (rareResponse(5)) {
      response = "I want some cheeseburgers just to eat, Im talking ketchup, My fella mustard on the beat, You gotta put a lot of lettuce please, Because I like to have a lot of green. I remember eating outside with my whole team, Now a fella gotta stay home cause of quarentine, I want 2 McChickens and fries cause I'm hungry, You look broke! Like my fries you looking salty, Get me McFlurries, make the Oreos Drip Drip, Straight up out McDonald's with no Tip Tip, And i want a pint of lean I'ma Sip Sip, You gotta buy them baked cookies that Chocolaty Chip, And i want 50 Apple pies i didn't forget that. If you mess up then I'll punch you I didn't forget that, And if the machine is broken then you gonna get slapped. You not my homie now if you do not come back. YOU GOTTA HURRY NOW! I know you heard that, Young fella stomach grumbling cause I wanna Big Mac. Why you still looking at me with that ugly hat? You gotta go now so you better run fast.";
    }
		
    if (whichResponse == 0) 
		{
			response = "Interesting, tell me more. Or don't. Please don't.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm. How about we talk like normal people";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so? Cuz I don't really care";
		}
    else if (whichResponse == 4)
    {
      response = "How about we talk about: " + Topics[randomInt(4)-1];
    }

		return response;
	}

}
