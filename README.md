
A new game in carrom-board called Clean Strike is played by 2 players with multiple turns. A
turn has a player attempting to strike a coin with the striker. Players alternate in taking turns.
The game is described as follows:
-There are 9 black coins, a red coin and a striker on the carrom-board

- Strike - When a player pockets a coin he/she wins a point
- Multi-strike - When a player pockets more than one coin he/she wins 2 points. All, but 2
coins, that were pocketed, get back on to the carrom-board
- Red strike - When a player pockets red coin he/she wins 3 points. If other coins are
pocketed along with red coin in the same turn, other coins get back on to the
carrom-board
- Striker strike - When a player pockets the striker he/she loses a point
- Defunct coin - When a coin is thrown out of the carrom-board, due to a strike, the player
loses 2 points, and the coin goes out of play
- When a player does not pocket a coin for 3 successive turns he/she loses a point
- When a player fouls 3 times (a foul is a turn where a player loses, at least, 1 point),
he/she loses an additional point
- A game is won by the first player to have won at least 5 points, in total, and, at least, 3
points more than the opponent
- When the coins are exhausted on the board, if the highest scorer is not leading by, at
least, 3 points or does not have a minimum of 5 points, the game is considered a draw
Write a program that takes in the outcome of each turn as input and outputs the result of the
game as and when applicable along with necessary statistics that supports the result. Please
find sample input and output below:
Sample Input:
Player 1: Choose an outcome from the list below
1. Strike
2. Multistrike
3. Red strike
4. Striker strike
5. Defunct coin
6. None

### Player 2: Choose an outcome from the list below
1. Strike
2. Multistrike
3. Red strike
4. Striker strike
5. Defunct coin
6. None
> 6
.
.
.

 ### Player 1 won the game. Final Score: 15-1

# OOMD Design
# Controller
### Class
- `com.amaap.cleanstrike.controller.PlayerController`
   - `createPlayers(int number ,int id)` 


- `GameStateController`
   - `GetStatesFor(List<players>)`

  
# Domain  
## Model
### Class
  - `CarromBoardCoins`
  - `Outcomes`
## Service(Inner)
### Class
- `outComeEvaluator`


# Service(Outer)
### Class
- `GameService`
  - `createPlayers(int number ,int id )`
  - `playeGame(List<Player>)`
  - `displayWinner()`

## Repository
### Class
- `PlayerControllerRepository`
- `GameControllerRepository`




----------------------------------------------

# Design Description
# Controller Layer:

## com.amaap.cleanstrike.controller.PlayerController:

- Manages player interactions and data.
- Handles creating user entities with unique identifiers.
- This controller is responsible for user-related operations.

## GameStateController:

- Manages the game's flow and logic.
- Orchestrates game progression and enforces game rules.
- This controller handles the core gameplay mechanics.

# Domain Layer:

## Model:

- Contains domain entities such as carrom, coins, and outcomes.
- These entities represent the core concepts of the game and encapsulate its state and behavior.

## Inner Service:

- Includes services responsible for providing domain-level functionalities.
  - **GameEvaluateService**: Takes user input at every step, evaluates it using the game outcomes, and updates the game state. It interacts with other services to update the game's progress.

# Service Layer:

## Outer Service:

- Includes services responsible for core functionalities.
  - **CreateUserService**: Creates new users with unique identifiers.
  - **PlayGameService**: Initiates and manages the game's progression.
  - **DisplayWinnerService**: Retrieves information from the repository to display the game's winner.

# Repository Layer:

## PlayerControllerRepository:

- Stores and manages user data, including unique identifiers.
- Responsible for creating users.

## GameControllerRepository:

- Stores the initial states of users (e.g., scores initialized to 0).
- May interact with a database to store and retrieve game states for winner declaration and state updates.
 


