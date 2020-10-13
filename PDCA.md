- loadAllItemsInfos
P: 1 min
D: 1 min
C:
A:

- buildReceiptInfo
P: 10 mins
D: 30 mins
C:
A:

- formatReceipt
P: 5 mins
D: 10 mins
C: Was deciding to just do a traditional for each but seems code is not that clean.
A: Refactored it to Stream

- buildReceiptInfoDetails
P: 5 mins
D: 10 mins
C:
A:

- calculateSubtotal
P: 5 mins
D: 10 mins
C:
A:

- receiptInfos
P: 2 mins
D: 2 mins
C: already done the part where this function but was not able to get the total in a good way
A: made it a global variable and made the function containing it void so that I can also include from the stream of list I had at that block

- total
P: 2 mins
D: 5 mins
C: was deciding if I should make this a function since I think repeating the stream of the list of barcodes which I already had would be redundant
A: made it a global variable and included on the stream