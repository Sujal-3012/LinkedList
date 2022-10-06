//Full functionality is in intellij 
private void bubbleSort(int row , int col){
        if (row == 0){
            return;
        }
        if (col < row){
            Node first = fetchNode(col);
            Node second = fetchNode(col + 1);
            if (first.value > second.value){
                //swap
                if (first == head){
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if (second == tail) {
                    Node prev = fetchNode(col - 1);
                    prev.next = second;
                    tail = first;
                    first.next = null;
                    second.next = tail;
                } else {
                    Node prev = fetchNode(col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubbleSort(row , col + 1);
        } else {
            bubbleSort(row - 1 , 0);
        }
    }
