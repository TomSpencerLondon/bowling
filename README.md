# Bowling Kata

This description is based on the **Bowling Game Kata** from *Adventures in C#: The Bowling Game*.

---

## Problem Description

Create a program that calculates the total score for a single game of American Ten-Pin Bowling, given a valid sequence of rolls. The program **will not**:

1. Check for valid rolls.
2. Check for the correct number of rolls or frames.
3. Provide scores for intermediate frames.

This simplification is intentional to keep the kata lightweight and focused on the core logic of scoring. Extensions to handle the above cases can be added later as needed.

---

## Scoring Rules

1. Each game consists of **10 frames**.
2. In each frame, the bowler has up to **two rolls** to knock down all 10 pins:
    - If the bowler fails to knock down all 10 pins in two rolls, their score for the frame is the total number of pins knocked down in those two rolls.
    - If the bowler knocks down all 10 pins in two rolls, it is a **spare**. The score for the frame is **10 + the number of pins knocked down in the next roll**.
    - If the bowler knocks down all 10 pins on the first roll, it is a **strike**. The score for the frame is **10 + the number of pins knocked down in the next two rolls**.

3. In the **10th frame**:
    - If the bowler scores a spare, they get **one bonus roll**.
    - If the bowler scores a strike, they get **two bonus rolls**.
    - Bonus rolls are only used to calculate the score for the 10th frame and do not count as additional frames.

4. The total game score is the sum of all frame scores.

For detailed rules on how to score a bowling game, refer to [How to Score for Bowling](https://out-of-bounds.co.uk/how-points-are-calculated-in-bowling/).

---

## Key Challenges

### Lookahead Scoring
- **Strikes** and **spares** require looking ahead to future rolls to calculate the frame score:
    - For a strike, you need the next **two rolls**.
    - For a spare, you need the next **one roll**.
- This lookahead mechanism adds complexity to the scoring logic.

---

## Suggested Test Cases

Below are some test cases to validate the scoring logic:

1. **Perfect Game**:  
   Input: `XXXXXXXXXXXX`  
   Scoring:
    - 10 frames * 30 points = **300 points**
    - (12 rolls: 12 strikes)

2. **All 9 and Miss**:  
   Input: `9-9-9-9-9-9-9-9-9-9-`  
   Scoring:
    - 10 frames * 9 points = **90 points**
    - (20 rolls: 10 pairs of `9` and `-`)

3. **All Spares with 5 Bonus**:  
   Input: `5/5/5/5/5/5/5/5/5/5/5`  
   Scoring:
    - 10 frames * 15 points = **150 points**
    - (21 rolls: 10 pairs of `5/` plus a final roll of `5`)

---

## Insights and Comments

### Key Takeaways from the Kata:
- The challenge lies in handling the **lookahead** logic for strikes and spares.
- The kata emphasizes simplicity, so tracking frames and bonus rolls explicitly is crucial to avoid confusion.
- Test-driven development (TDD) can be highly beneficial here, allowing incremental improvements to the scoring logic.

### Challenges in Design:
- Handling the **end game logic** (10th frame and bonus rolls) can become tricky without frame tracking.
- Writing out possible end-of-game combinations (e.g., strike + two bonus rolls, spare + one bonus roll) can help clarify edge cases.

--- 

### Attribution

Insights and inspiration for this kata were derived from *Adventures in C#: The Bowling Game* and commentary by practitioners like RudyXDesjardins.


# Simple Bowling Scoring Rules

Here’s a simplified breakdown of how bowling scoring works:

---

## **Basic Rules**
- A game consists of **10 frames**.
- In each frame, you have up to **two rolls** to knock down all 10 pins.
- Scoring depends on whether you get a **strike**, **spare**, or an **open frame**.

---

## **How to Score Each Frame**
1. **Strike (`X`)**:
   - All 10 pins knocked down on the **first roll**.
   - Score = 10 + pins knocked down in the **next two rolls**.

2. **Spare (`/`)**:
   - All 10 pins knocked down in **two rolls**.
   - Score = 10 + pins knocked down in the **next roll**.

3. **Open Frame**:
   - Fewer than 10 pins knocked down in two rolls.
   - Score = Total number of pins knocked down in those two rolls.

---

## **Special Rules for the 10th Frame**
- If you get a **strike** in the 10th frame, you get **2 bonus rolls**.
- If you get a **spare** in the 10th frame, you get **1 bonus roll**.
- If you don’t get a strike or spare, your score is just the total pins knocked down in two rolls.

---

## **Examples of Scoring**
- **Perfect Game**: `XXXXXXXXXXXX`
   - 12 rolls (10 frames + 2 bonus rolls for strikes).
   - Score = 300 (maximum score).

- **All 9 and Miss**: `9-9-9-9-9-9-9-9-9-9-`
   - Score = 90 (9 points per frame).

- **All Spares with Final 5**: `5/5/5/5/5/5/5/5/5/5/5`
   - Score = 150 (15 points per frame).

---

## **Tips for Scoring Higher**
- **Focus on Spares**: Converting spares consistently can dramatically improve your score.
- **Practice Strikes**: Consecutive strikes add up quickly due to bonus scoring.
- **Consistency is Key**: Aim for smooth, repeatable throws for better accuracy.

Enjoy your bowling! 🎳

