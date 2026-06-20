# AI Assignment Project

This repository contains Java implementations of fundamental Artificial Intelligence algorithms and interactive environments, organized into clean, modular workspaces.

---

## Project Structure

```text
ArtificialIntelligence-Assignment/
├── README.md               # Project documentation
├── AlphaBeta/
│   └── AlphaBetaVisualizer.java  # Game Tree Alpha-Beta search & DOT generator
├── Hidden Markov Model/
│   ├── ViterbiHMM.java     # Network Intrusion Detection Viterbi decoder
│   └── HMM probability plot.png # Plotted probability path state curve
│   └── HMM output.png # Console Output
└── MiniMax Algorithm/
    └── TicTacToe.java      # Premium Swing UI Tic-Tac-Toe Minimax Game
```

---

## Project Overview

The project consists of three main Java modules demonstrating key concepts in artificial intelligence:

### 1. Alpha-Beta Pruning

An implementation of the Alpha-Beta pruning minimax optimization framework featuring runtime alpha/beta metadata tracking and automated visualization output.

**Core Logic:** Dynamically checks mathematical bounds (`β ≤ α`) to discard redundant structural subtrees.

**Features:**
- Tracks precise historical terminal `α` and `β` metrics per depth frame.
- Captures array coordinates of all dropped structural connections.
- Generates visual output showing which branches were pruned.

---

### 2. Hidden Markov Model — Viterbi Algorithm

Implementation of the Viterbi algorithm for finding the most likely sequence of hidden states in a Hidden Markov Model.

**Scenario:** A system infrastructure guessing internal system health (**Healthy** vs. **Under Attack**) based entirely on live network alert logs (`Low Traffic`, `High Traffic`, `Failed Login`).

**Features:**
- Calculates explicit joint state-path log probabilities.
- Computes optimal hidden state sequences.
- Formats and prints a structured console text data-grid logging matrix trajectories over runtime.
- Includes an exported probability path curve (`HMM probability plot.png`) showing state boundary crossovers.

---

### 3. Tic-Tac-Toe with AI

An interactive Tic-Tac-Toe game where you can play against an AI opponent powered by the Minimax algorithm.

**Features:**
- Human vs. AI gameplay.
- AI uses Minimax with Alpha-Beta pruning.
- Real-time algorithm dashboard diagnostics capturing execution step index targets and evaluation matrix states.
- Tracks game state and win conditions.

---

## Dependencies

- **Runtime Environment:** Java Development Kit (JDK) 8 or higher (JDK 17 or JDK 21 recommended).
- **IDE Setup:** Works out-of-the-box in Visual Studio Code (with the Extension Pack for Java installed) or IntelliJ IDEA.
- **`java.awt` (Abstract Window Toolkit):** Used as the foundational graphics engine for components like `Graphics2D`, custom strokes, rendering hints (anti-aliasing), and coordinate scaling via `AffineTransform` to construct crisp vector shapes.
- **`javax.swing`:** Powers the graphical user interface components (`JFrame`, `JPanel`, `JButton`, `JLabel`, and thread-safe animation delays via `javax.swing.Timer`). Drives the main event dispatch thread for smooth real-time human interactions.
- **`java.util`:** Handles data tracking and algorithmic structures (`ArrayList`, `List`) used to compile dynamic branch evaluations and history paths.

---

## Execution Guide

### Running Modules via Terminal

From your repository's root directory, navigate to your folder of choice to compile and execute the native Java classes:

---

#### Alpha-Beta Visualizer

```bash
cd alphabeta
javac AlphaBetaVisualizer.java
java AlphaBetaVisualizer
```

> **Visualizing the Tree:** Copy the console block output starting with `digraph G { ... }` and paste it directly into a web engine like [Graphviz Online](https://dreampuf.github.io/GraphvizOnline/) to view your color-coded tree diagram model.

---

#### Hidden Markov Model

```bash
cd hmm
javac ViterbiHMM.java
java ViterbiHMM
```

---

#### Interactive Tic-Tac-Toe Game

```bash
cd tictactoe
javac TicTacToe.java
java TicTacToe
```

---

## How to Play Tic-Tac-Toe

- The board is represented as a `3×3` grid with a Swing GUI interface.
- You play as **X**, the AI plays as **O**.
- Click any empty cell to make your move.
- The AI responds instantly using the Minimax algorithm to determine its optimal move.
- The game ends when someone wins or the board is full (draw).

---

## Technical Metrics Reference

### Viterbi Decoding Framework

- **Time Complexity:** `O(N² × T)` where `N` denotes structural state dimensions (`2`), and `T` indicates observation time series stream length (`4`).
- **Memory Footprint:** `O(N × T)` array matrix allocation tracking weights.
- **Use Case:** Hidden state inference, network intrusion detection.

### Game Tree Search Models

- **Alpha-Beta Pruning:** Optimizes standard branching factors down from an `O(b^d)` exponential scale to `O(b^(d/2))` under optimal configuration layouts.
- **Minimax (Tic-Tac-Toe):** Exhaustively scans the remaining turn state space (`9!` maximum permutations) down to terminal leaf nodes to guarantee an optimal choice that ensures the AI cannot lose.

---

## Troubleshooting

### Swing GUI does not open
**Solution:** Ensure you are running Java in a desktop environment. Headless server environments do not support `javax.swing`. Use a local machine or IDE instead.

### Graphviz tree not rendering
**Solution:** The Java program outputs raw DOT language to the console. Copy the full block starting with `digraph G {` and paste it into [Graphviz Online](https://dreampuf.github.io/GraphvizOnline/) to render the tree visually.
