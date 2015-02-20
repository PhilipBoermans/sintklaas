package be.cronos.sinterklaas.service;

import be.cronos.sinterklaas.command.LetterCommand;

public interface LetterBuilderService {

    public byte[] generate(LetterCommand command);

}
