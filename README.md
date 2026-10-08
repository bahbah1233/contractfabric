# Contract Fabric

A Fabric mod port of contractnpc for Minecraft 1.21.1.

## Features

- **Merchant Contract Item**: A unique item that spawns a merchant NPC
- **Player-like NPC**: Custom entity that resembles a player character
- **Static Merchant**: The NPC is invulnerable and doesn't move
- **Creative Tab**: Merchant contract item appears in the Tools & Utilities creative tab

## Building

Run `gradlew build` to build the mod JAR file.

## Development

This mod uses Fabric API for Minecraft 1.21.1 (Java 21).

### Structure

- `src/main/java/net/bayruby/contractfabric/` - Main mod code
- `src/main/java/net/bayruby/contractfabric/entity/` - Entity definitions
- `src/main/java/net/bayruby/contractfabric/item/` - Item definitions
- `src/client/java/net/bayruby/contractfabric/` - Client-side code
- `src/client/java/net/bayruby/contractfabric/client/` - Renderers and client utilities
