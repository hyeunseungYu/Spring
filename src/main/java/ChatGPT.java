import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ChatGPT {
    public static void main(String[] args) {


        OpenAiService service = new OpenAiService("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", Duration.ZERO);

        final List<ChatMessage> messages = new ArrayList<>();
        final ChatMessage systemMessage = new ChatMessage(ChatMessageRole.USER.value(),


                "tell me about yourself"


        );
        messages.add(systemMessage);

        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest
                .builder()
                .model("gpt-3.5-turbo")
                .messages(messages)
                .build();

        ChatCompletionChoice chatCompletionChoice = service.createChatCompletion(chatCompletionRequest).getChoices().get(0);
        System.out.println("here's answer: \n" +chatCompletionChoice.getMessage().getContent());
        System.out.println("==============================================");

    }
}
