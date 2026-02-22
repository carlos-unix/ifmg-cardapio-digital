# IFMG Cardápio Digital v1.0.1

IFMG Cardápio Digital is a Java-based Telegram bot integrated with the Telegram Bot API. It allows users to consult the daily menu of the Federal Institute of Education, Science and Technology of Minas Gerais (IFMG) campuses directly through Telegram.

🔗 Access the bot: https://t.me/IFMGCD_bot


## Features

- Consult daily campus menu
- Select campus via command
- Direct integration with official campus websites by web scraping
- Secure bot token handling

## Current Version (v1.0.1)

Currently supports:
- São João Evangelista campus
- Ouro Preto campus
- Formiga campus
- Governador Valadares campus
- Fallback message for campuses without an official menu website

Future versions will include:
- Error verification
- More stylized text sent by bot 


## Technologies Used

- Java
- Telegram Bot API
- Jsoup (HTML parsing)
- Maven


## How to Use

1. Access the bot on Telegram.
2. Run the command `/start`.
3. Use `/help` to see available campus commands.
4. Type the corresponding command according to the campus you wanna do the consult.

## Running Locally

For security reasons, the bot token is not included in this repository.

To run locally:

1. Create a bot via BotFather on Telegram.
2. Replace the `BOT_TOKEN` variable in `Bot.java`.
3. Run the application.

Official Telegram documentation about bot token creation:
https://core.telegram.org/bots/tutorial#getting-ready

## LICENSE

Please refer to the LICENSE file for usage terms.

## Logo

![Bot logo](./assets/bot-logo.png "Bot logo")