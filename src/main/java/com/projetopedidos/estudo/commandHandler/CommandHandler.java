package com.projetopedidos.estudo.commandHandler;

import com.projetopedidos.estudo.command.Command;

public interface CommandHandler<TCommand extends Command, R> {
  R handle(TCommand command);
}
