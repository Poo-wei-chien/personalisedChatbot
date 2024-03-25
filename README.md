# personalisedChatbot

Hi everyone, very greatesful that you are picking up the chanllenge to develop AI chatbot using LLM model, Llama 2. 

For this totutial, I will teach step by step implemention of Llama 2 to your project.

## Step 1 Run 
Llama 2 with an API
https://replicate.com/blog/run-llama-2-with-an-api?input=http#choosing-which-model-to-use

By refering the link above, you need to create an API key in 'Replicate'. In above link, we can use the above API in Node.js, Python and HTTP. For Node.js and Python we need to declare the API key in environement variable. Follow <a href = 'https://www.youtube.com/watch?v=znyhTD4McOg'>here</a> to setup the API key in environment variable. Meanwhile, for Java, we are using the HTTP request to sent the API, there is some library to handle HTTP request, feel free to explore. 

## Step 2 
Refer to my personalisedChatbot.java code, I have create a class to read the Handbook.txt as the chatbot main knowledge, then only put the prompt into the API. The content inside the Handbook.txt is free to change and append a new thing. 

## Step 3
There are more setting for the 'input' of the jsonObject, free feel to explore too, if you want to customise more, else just give the default input of 'prompt'.

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

This is the final output of the chatbot.
![image](https://github.com/Poo-wei-chien/personalisedChatbot/assets/92501486/7ad4d235-e292-4562-9e00-2f8b327460d1)

Reminder:

1. API for each Github account has its limit, so don't wasted. If your API key is reached the limit, do ask help from your team members.
2. When declare the 'Authorization' headers in Postman (during testing), remember to create a new header and put the Value as 'Token <<Your API Key>>' instead of using Barrer Token.
