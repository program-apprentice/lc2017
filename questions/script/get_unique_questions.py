import os

path = 'stat'

questions = set()

for filename in os.listdir(path):
    file_path = path + '/' + filename
    f = open(file_path)
    d = f.readlines()
    for line in d:
        questions.add(line)
    f.close()

for line in questions:
    print line