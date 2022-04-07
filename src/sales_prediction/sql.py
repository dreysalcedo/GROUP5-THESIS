# -*- coding: utf-8 -*-
"""
Created on Thu Sep 30 18:51:27 2021

@author: User
"""

import mysql.connector

db = mysql.connector.connect(
     host = "sdffea.com",
    user = "ezpaydbadmin",
    password = "WvsuCictThesis2020",
    database = "ezpaydb"     
    )
cursor = db.cursor()

def FutureInsertBlob(FilePath):
    with open(FilePath, "rb") as File:
        BinaryData = File.read()
    SQLStatement = "INSERT INTO futureprediction(image)VALUES(%s)" 
    cursor.execute(SQLStatement, (BinaryData, ))
    db.commit()

def FutureRetrieveBlob(id):
     SQLStatement2 = "SELECT * FROM futureprediction WHERE id = '{0}'"
     cursor.execute(SQLStatement2.format(str(id)))
     MyResult = cursor.fetchone()[1]
     StoreFilePath = "static/uploads/img{0}.jpg".format(str(id))
     print(MyResult)
     with open(StoreFilePath, "wb") as File:
         File.write(MyResult)
         File.close()

def CurrentInsertBlob(FilePath):
    with open(FilePath, "rb") as File:
        BinaryData = File.read()
    SQLStatement = "INSERT INTO currentprediction(image)VALUES(%s)" 
    cursor.execute(SQLStatement, (BinaryData, ))
    db.commit()

def CurrentRetrieveBlob(id):
     SQLStatement2 = "SELECT * FROM currentprediction WHERE id = '{0}'"
     cursor.execute(SQLStatement2.format(str(id)))
     MyResult = cursor.fetchone()[1]
     StoreFilePath = "static/uploads/img{0}.jpg".format(str(id))
     print(MyResult)
     with open(StoreFilePath, "wb") as File:
         File.write(MyResult)
         File.close()




print("PRESS: 1 = insert image in futurepredictiondb \n 2 = insert image in currentpredictiondb \n 3 = read image from futurepredictiondb \n 4 = read image from currentpredictiondb")
MenuInput = input("Enter: ") 
#insert image in futureprediction db
if int(MenuInput) == 1:
    UserFilePath = input("Enter File Path: ")
    FutureInsertBlob(UserFilePath)
  #insert image in currentprediction db  
elif int(MenuInput) == 2:
     UserFilePath = input("Enter File Path:")
     CurrentInsertBlob(UserFilePath)
#read image in futureprediction db    
elif int(MenuInput) == 3:
     UserIDchoice= input("Enter id: ")
     FutureRetrieveBlob(UserIDchoice)
#read image in currentprediction db    
elif int(MenuInput) == 4:
     UserIDchoice= input("Enter id: ")
     CurrentRetrieveBlob(UserIDchoice)











# print("Type 1 for futureprediction or 2 for currentprediction")
# MenuInput = input()
# #if future prediction
# if int(MenuInput) == 1:
#     input_future = input("Press 1 to insert image in futureprediction db or Press 2 to read image from futureprediction db: ")
#     if(input_future == 1):
#          UserFilePath = input("Enter File Path:")
#          FutureInsertBlob(UserFilePath)
#     elif (input_future == 2):
#        UserIDchoice= input("Enter id: ")
#        FutureRetrieveBlob(UserIDchoice)
# #if currentprediction
# elif int(MenuInput) == 2:
#     input_current = input("Press 1 to insert image in currentprediction db or Press 2 to read image from currentprediction db: ")
#     if(input_future == 1):
#          UserFilePath = input("Enter File Path:")
#          CurrentInsertBlob(UserFilePath)
#     elif (input_future == 2):
#        UserIDchoice= input("Enter id: ")
#        CurrentRetrieveBlob(UserIDchoice)
    
    
    
    
    
    
# print("1. insert image\n2. read image" )
# MenuInput = input()
# if int(MenuInput) == 1:
#     UserFilePath = input("Enter File Path:")
#     InsertBlob(UserFilePath)
# elif int(MenuInput) == 2:
#     UserIDchoice= input("Enter id: ")
#     RetrieveBlob(UserIDchoice)