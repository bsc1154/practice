print("sdfsadf")

#user딕셔너리에 name email age를 넣어라
user = {}
user["name"] = "사용자"
user["email"] = "khl1154@gsretail.com"
user["age"] = 25
print(user)

for keys in user:
    print(f"{keys}: {user[keys]}")

# 특정 키가 존재하는지  확인
user = {"name": "사용자", "email": "user@test.com", "age": 25}
print("email" in user)

if "email" in user:
    print("email 키는 존재합니다.")


# 사전 병합
dic1 = {"A": 1, "B": 2}
dic2 = {"B": 3, "C": 4}
{ **dic1, **dic2 }