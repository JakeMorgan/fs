package com.accenture.fe.Enums;
    public enum OrderStatus {
        Created,
        Sent,
        Complited;

        public OrderStatus next() {
            switch (this) {
                case Created:
                    return Sent;
                case Sent:
                    return Complited;
            }
            return this;
        }
    }
