# Personalised Chatbot Integration using Llama 2

Hello everyone! I'm excited to guide you through the process of developing an AI chatbot using the Llama 2 model.

## Step 1 Setting Up Llama 2 with an API

To begin, we'll set up Llama 2 with an API. Follow the instructions outlined in the <a href = 'https://replicate.com/blog/run-llama-2-with-an-api?input=http#choosing-which-model-to-use'> Run Llama 2 with an API </a>guide.

1. Create an API key in 'Replicate'.
2. Depending on your preferred programming language (Node.js, Python, or Java), declare the API key as an environment variable. You can watch this <a href = 'https://www.youtube.com/watch?v=znyhTD4McOg'>video</a> for setting up the API key in the environment variable.
3. For Java, utilize HTTP requests to send the API. You can explore libraries to handle HTTP requests.

## Step 2  Implementing Retrieval-Augmented Generation (RAG) in Java
In my personalisedChatbot.java code, I've created a class to incorporate Retrieval-Augmented Generation (RAG) functionality. This class reads from Handbook.txt, serving as the chatbot's main knowledge repository, which we use as a mock RAG process. The content within Handbook.txt can be freely modified and expanded to enrich the chatbot's knowledge base.

By integrating RAG into our Java implementation, we ensure that the chatbot leverages both retrieval-based and generative-based approaches to provide contextually relevant and coherent responses. This approach enhances the chatbot's conversational capabilities by incorporating both retrieved information and generated content.

## Step 3 Customizing Input Settings
You can further customize the 'input' settings for the JSON object, else just giving the default input of 'prompt' will do. Here's an example of input settings:
```
input={
        "debug": False,
        "top_k": 50,
        "top_p": 1,
        "prompt": "Can you write a poem about open source machine learning? Let's make it in the style of E. E. Cummings.",
        "temperature": 0.5,
        "system_prompt": "You are a helpful, respectful and honest assistant. Always answer as helpfully as possible, while being safe. Your answers should not include any harmful, unethical, racist, sexist, toxic, dangerous, or illegal content. Please ensure that your responses are socially unbiased and positive in nature.\n\nIf a question does not make any sense, or is not factually coherent, explain why instead of answering something not correct. If you don't know the answer to a question, please don't share false information.",
        "max_new_tokens": 500,
        "min_new_tokens": -1
    }
```
This JSON object includes parameters like debug, top_k, top_p, prompt, temperature, system_prompt, max_new_tokens, and min_new_tokens. Adjust these settings according to your requirements.

This is the final output of the chatbot.
![image](https://github.com/Poo-wei-chien/personalisedChatbot/assets/92501486/7ad4d235-e292-4562-9e00-2f8b327460d1)

### Reminder:

1. Be mindful of the API limits associated with each Github account. Coordinate with your team members if your API key reaches its limit.
2. When declaring the 'Authorization' headers in Postman (during testing), ensure to create a new header with the Value as 'Token <Your API Key>' instead of using Barrer Token.
