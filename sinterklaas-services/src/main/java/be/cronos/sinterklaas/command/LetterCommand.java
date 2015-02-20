package be.cronos.sinterklaas.command;

import javax.validation.constraints.NotNull;

public class LetterCommand {

    @NotNull
    private Long image;

    @NotNull
    private Long text;

    public Long getImage() {
        return image;
    }

    public void setImage(Long image) {
        this.image = image;
    }

    public Long getText() {
        return text;
    }

    public void setText(Long text) {
        this.text = text;
    }

}
