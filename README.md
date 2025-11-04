# ChibiAssistant (Java)

ChibiAssistant is a small 2D chibi demo/game. This repository contains the game sources and assets and a short roadmap for upcoming AI-powered features that will enhance gameplay, NPC behavior, and content generation.

This README focuses on a short project presentation, the AI integration roadmap, and only the simplest build/run/package commands using the JDK tools (no build tools required).

Project at-a-glance
- Language: Java
- Entry point: `chibiassistant.Main`
- Layout (standard):
	- `src/main/java/...` — Java sources
	- `src/main/resources/...` — assets (images, etc.)

Prerequisites
- JDK 11+ installed and `javac`/`java` available on PATH

Simple build & run (copy-paste)
Run these commands from the project root (`C:\java\res`). These use only `javac`, `java`, and `jar`.

1) Compile

```powershell
cd C:\java\res
mkdir out
javac -d out src\main\java\chibiassistant\*.java src\main\java\chibiassistant\entity\*.java
```

2) Run

```powershell
cd C:\java\res
java -cp out chibiassistant.Main
```

3) Package (create an executable jar that includes compiled classes and resources)

```powershell
cd C:\java\res
echo Main-Class: chibiassistant.Main > manifest.txt
jar cfm releases\chibiassistant-0.1.0.jar manifest.txt -C out . -C src\main\resources .
del manifest.txt
```

Notes
- Resource loading: code uses `getResourceAsStream("/assets/...")`. Packaging step above adds `src/main/resources` into the jar so resources are available at that path.
- If you add new packages or source files, include them in the `javac` command or use the recursive javac pattern (not shown here to keep commands minimal).

AI integration roadmap (planned features)
The project is intended to evolve with AI-driven features. Planned items:

- Dynamic NPC behavior: use small ML models or rule-based generative systems to create more lifelike NPCs (dialogue, pathfinding with learned heuristics).
- Procedural content generation: generate levels, tile layouts, and item placements with configurable generators or AI-assisted editors.
- Conversational assistant: in-game assistant powered by a conversational model to answer player questions, provide hints, or adapt difficulty.
- Asset variation: use AI tools to procedurally generate or augment sprite variations (palette swaps, additional poses) while keeping author control.
- Automated testing & tuning: use lightweight simulations and AI to tune movement parameters and difficulty curves.

These features are planned as optional modules — the core game remains runnable with the simple javac/java commands above.

Contributing
- Pull requests welcome. Keep changes small and document behavior changes.
- If adding AI integrations, include wiring that keeps the core game functional when the AI module is disabled (feature flags or modular loading).

Packaging & releases
- Place built jars in the `releases/` folder. The project keeps an empty `releases/.gitkeep` so you can add release assets without creating an empty-directory commit.

License
- MIT (see `LICENSE`)

