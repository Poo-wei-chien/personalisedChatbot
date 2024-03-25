import replicate

# Read the content of the text file
with open("./data/test.txt", "r", encoding="utf-8") as file:
    text = file.read()

# Perform a query on the text
query = "What’s the interest rate I can earn daily?"
result = "User Question = " + query + "\nHandbook = { " + text + " }"

# output = replicate.run(
#     "meta/llama-2-70b-chat:02e509c789964a7ea8736978a43525956ef40397be9033abf9fd2badfe68c9e3",
#     input={
#         "debug": False,
#         "top_k": 50,
#         "top_p": 1,
#         "prompt": query,
#         "temperature": 0.5,
#         "system_prompt": "You are a helpful, respectful and honest assistant. Always answer as helpfully as possible, while being safe. Your answers should not include any harmful, unethical, racist, sexist, toxic, dangerous, or illegal content. Please ensure that your responses are socially unbiased and positive in nature.\n\nIf a question does not make any sense, or is not factually coherent, explain why instead of answering something not correct. If you don't know the answer to a question, please don't share false information. You also a personalise chatbot, so you need to go though what it's given in handbook first before answering the question.",
#         "max_new_tokens": 500,
#         "min_new_tokens": -1
#     }
# )

prompt = "[INST] <<SYS>>\nYou are a helpful, respectful and honest personalised customer service assistant, handbook is your extra knowledge to help the customer service system. Response professionally as customer service of E-Gringotts, digital bank.\n<</SYS>>\n" + result + "[/INST]"

output = replicate.run(
    "meta/llama-2-70b-chat:02e509c789964a7ea8736978a43525956ef40397be9033abf9fd2badfe68c9e3",
    input={
        "prompt": prompt,
    }
)

# The meta/llama-2-70b-chat model can stream output as it's running.
# The predict method returns an iterator, and you can iterate over that ou  tput.
for item in output:
    # https://replicate.com/meta/llama-2-70b-chat/api#output-schema
    print(item, end="")
