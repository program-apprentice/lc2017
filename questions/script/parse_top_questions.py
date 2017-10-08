import json


f = open("facebook.json")

data = f.read()

j = json.loads(data)

questions = j["stat_status_pairs"]

def getDifficulty(question):
    level = question["difficulty"]["level"]
    if level == 2:
        return "Medium"
    if level == 1:
        return "Easy"
    if level == 3:
        return "Hard"


for question in questions:
    stat = question["stat"]
    level = getDifficulty(question)
    passing_rate = stat["total_acs"]/float(stat["total_submitted"])
    passing_rate = passing_rate * 100
    print "[%03d] %-61s %-6s (%2.2f %%)" % (stat["question_id"], stat["question__title"], level, passing_rate)