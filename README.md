I chose this protocol, and this is the design I have so far. REVISED VERSION

Attributes:
The name of the cricket team.
Show record for team // the number of wins recorded for the team and the number of losses recorded for the team.
RecordWins() and RecordLosses(). 

Methods: These methods implement in the Team class
showRecord(): show record numbers for the team.
recordWin(): Increments the number of wins for the team.
recordLoss(): Increments the number of losses for the team.

Team data Structure Design:

ArrayList<String> teamNames = new ArrayList<>(); to hold instances of the Team class.



Client Request	Server Response	Description
Team 
Show-Record Team
“Show_Record IND”
	
“IND 4W 1L”
	The name of the cricket team, 
Team Record Wins + Loses 

Wins 

Record-Win Team 
“Record_Win IND”	 

“IND 4W 1L”	

Return the number of wins for the team.


Losses 


Record-Loss Team
“Record_Loss ENG”	


“ENG 5W 3L”	

Returns the number of losses for the team.

QUIT	None	Quit the connection
        

