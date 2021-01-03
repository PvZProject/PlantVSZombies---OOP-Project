# PlantVSZombies---OOP-Project
Instructor: Mr. Tran Thanh Tung - Tuesday Morning

@Author: Phan Nguyen Xuan Phuc

- The Level class includes 5 sub-class: Level1, Level2, Level3, Level4, Level5.
  + The super class Level:
        => "update()" method is used to check whether the game is over or NOT. // 2 Variables: LevelIsDone = false, gameover = false;
        => There are 2 rounds: Which are the 2 big waves of zombies will attack the garden. // 
        => 
        'Counter' are a variable that is used to help spawning Zombies
  + Level1: 2 Planets are available, Music contains Level1
      15 seconds for are the time for player to setup their plant and kill the FIRST ZOMBIES, then 'counter' also increases by 1
      15 seconds 
  + Level2: 3 Planets are available, Remove music of Level1 and alternate with the music of Level2,
  
  + Level3: 4 Planets are available, Remove music of Level2 and alternate with the music of Level3,
  
  + Level4: 5 Planets are available, Remove music of Level3 and alternate with the music of Level4,
  
  + Level5: 6 Planets are available, Remove music of Level4 and alternate with the music of Level5,
  
- Additional Feature: Easter Eggs (class Easter_Eggs)
  + Method: checkEasterEgg() is used to check whether the players haved figured it out the EE or NOT.
            * If "Yes": Players will receive 200 Sun as reward.
            * If "NO": The method will continue to check...
            
