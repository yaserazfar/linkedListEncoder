# Word-Based Move-to-Front Encoder

An adaptive, word-based move to front encoder

Uses a dynamic linked list comprised of self-referential data structures to read a text file and create it into a encoded file by refering to repeated words as indexes in a linked list.

Then decode that encoded file using the list of words and the indexes provided.

Commands to use:
1. make
2. java MTFencoder <fileToEncode>
3. java MTFdecode <fileToDecode>
