package com.bri64.discord.chillbot.web.routes;

import com.bri64.discord.DiscordBot;
import com.bri64.discord.audio.send.MusicScheduler;
import com.bri64.discord.chillbot.web.WebPlayer;
import com.bri64.discord.commands.RebootCommand;
import spark.Request;
import spark.Response;
import spark.TemplateEngine;

@SuppressWarnings("RedundantThrows")
public class PostRebootRoute extends PlayerRoute {

  public PostRebootRoute(DiscordBot bot,
      MusicScheduler scheduler,
      TemplateEngine templateEngine) {
    super(bot, scheduler, templateEngine);
  }

  @Override
  public Object handle(Request request, Response response) throws Exception {
    new RebootCommand(null, scheduler).execute();
    response.redirect(WebPlayer.HOME_URL);
    return null;
  }
}
