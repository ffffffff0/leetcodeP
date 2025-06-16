package main

type Node struct {
	val  int
	prev *Node
	next *Node
}

type LinkedList struct {
	head *Node
	tail *Node

	size int
}

func (l *LinkedList) addAtHead(value int) {
	newNode := &Node{
		val: value,
	}

	next := l.head.next

	l.head.next = newNode
	next.prev = newNode

	newNode.prev = l.head
	newNode.next = next

	l.size++
}

func (l *LinkedList) addAtTail(value int) {
	newNode := &Node{
		val: value,
	}

	prev := l.tail.prev

	prev.next = newNode
	l.tail.prev = newNode

}

func (l *LinkedList) Insert(value int) {
	newNode := &Node{
		val: value,
	}

	if l.head == nil {
		l.head = newNode
		l.tail = newNode
	} else {
		// insert node in linkedList tail
	}
}

func main() {
	list := &LinkedList{}
}
