# Controller Layer:

## PlayerController:

- Manages player interactions and data.
- Handles creating user entities with unique identifiers.
- This controller is responsible for user-related operations.

## GameController:

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
