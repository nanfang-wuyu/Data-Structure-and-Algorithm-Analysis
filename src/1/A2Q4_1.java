

public class A2Q4_1 {
    public static void main(String[] args) {
        if (0 == args.length) return;
        int n = args[0].length();
        double[] num = new double[3];//
        char[] cal = new char[2];//
        int nums = 0;
        int cals = 0;

        String strNumber = args[0];
        double result = 0.0;
        //to parse the string
        for (int i = 0; i < n; i++) {
            //System.out.print(args[0].charAt(i));
            switch (args[0].charAt(i)) {
                case '+':
                    cal = strNumber.toCharArray();
                    cals++;
                    break;
                case '-':
                    cal = strNumber.toCharArray();
                    cals++;
                    break;
                case '*':
                    cal = strNumber.toCharArray();
                    cals++;
                    break;
                case '/':
                    cal = strNumber.toCharArray();
                    cals++;
                    break;
                case '(':
                    for (int j = 0; j < n; j++) {
                        switch (args[0].charAt(i)) {
                            case ')':
                                if (i == 1) {
                                    if (j == 5) {

                                        if ('*' == cal[0]) {
                                            if ('+' == cal[1]) {
                                                result = num[0] * num[1] + num[2];
                                            } else if ('-' == cal[1]) {
                                                result = num[0] * num[1] - num[2];
                                            } else if ('*' == cal[1]) {
                                                result = num[0] * num[1] * num[2];
                                            } else if ('/' == cal[1]) {
                                                result = num[0] * num[1] / num[2];
                                            }
                                        } else if ('/' == cal[0]) {
                                            if ('+' == cal[1]) {
                                                result = num[0] / num[1] + num[2];
                                            } else if ('-' == cal[1]) {
                                                result = num[0] / num[1] - num[2];
                                            } else if ('*' == cal[1]) {
                                                result = (num[0] / num[1]) * num[2];
                                            } else if ('/' == cal[1]) {
                                                result = (num[0] / num[1]) / num[2];
                                            }
                                        } else if ('+' == cal[0]) {
                                            if ('+' == cal[1]) {
                                                result = (num[0] + num[1]) + num[2];
                                            } else if ('-' == cal[1]) {
                                                result = (num[0] + num[1]) - num[2];
                                            } else if ('*' == cal[1]) {
                                                result = (num[0] + num[1]) * num[2];
                                            } else if ('/' == cal[1]) {
                                                result = (num[0] + num[1]) / num[2];
                                            }
                                        } else if ('-' == cal[0]) {
                                            if ('+' == cal[1]) {
                                                result = (num[0] - num[1]) + num[2];
                                            } else if ('-' == cal[1]) {
                                                result = (num[0] - num[1]) - num[2];
                                            } else if ('*' == cal[1]) {
                                                result = (num[0] - num[1]) * num[2];
                                            } else if ('/' == cal[1]) {
                                                result = (num[0] - num[1]) / num[2];
                                            }
                                            System.out.printf("%s=%.2f", args[0], result);
                                        }

                                    } else if (j == 7) {
                                        if ('*' == cal[0]) {
                                            if ('+' == cal[1]) {
                                                result = num[0] * num[1] + num[2];
                                            } else if ('-' == cal[1]) {
                                                result = num[0] * num[1] - num[2];
                                            } else if ('*' == cal[1]) {
                                                result = num[0] * num[1] * num[2];
                                            } else if ('/' == cal[1]) {
                                                result = num[0] * num[1] / num[2];
                                            }
                                        } else if ('/' == cal[0]) {
                                            if ('+' == cal[1]) {
                                                result = num[0] / num[1] + num[2];
                                            } else if ('-' == cal[1]) {
                                                result = num[0] / num[1] - num[2];
                                            } else if ('*' == cal[1]) {
                                                result = (num[0] / num[1]) * num[2];
                                            } else if ('/' == cal[1]) {
                                                result = (num[0] / num[1]) / num[2];
                                            }
                                        } else if ('+' == cal[0]) {
                                            if ('+' == cal[1]) {
                                                result = num[0] + num[1] + num[2];
                                            } else if ('-' == cal[1]) {
                                                result = num[0] + num[1] - num[2];
                                            } else if ('*' == cal[1]) {
                                                result = num[0] + num[1] * num[2];
                                            } else if ('/' == cal[1]) {
                                                result = num[0] + num[1] / num[2];
                                            }
                                        } else if ('-' == cal[0]) {
                                            if ('+' == cal[1]) {
                                                result = num[0] - num[1] + num[2];
                                            } else if ('-' == cal[1]) {
                                                result = num[0] - num[1] - num[2];
                                            } else if ('*' == cal[1]) {
                                                result = num[0] - num[1] * num[2];
                                            } else if ('/' == cal[1]) {
                                                result = num[0] - num[1] / num[2];
                                            }
                                            System.out.printf("%s=%.2f", args[0], result);
                                        }

                                    }
                                } else if (i == 3) {

                                    if ('*' == cal[0]) {
                                        if ('+' == cal[1]) {
                                            result = num[0] * (num[1] + num[2]);
                                        } else if ('-' == cal[1]) {
                                            result = num[0] * (num[1] - num[2]);
                                        } else if ('*' == cal[1]) {
                                            result = num[0] * (num[1] * num[2]);
                                        } else if ('/' == cal[1]) {
                                            result = num[0] * (num[1] / num[2]);
                                        }
                                    } else if ('/' == cal[0]) {
                                        if ('+' == cal[1]) {
                                            result = num[0] / (num[1] + num[2]);
                                        } else if ('-' == cal[1]) {
                                            result = num[0] / (num[1] - num[2]);
                                        } else if ('*' == cal[1]) {
                                            result = num[0] / (num[1] * num[2]);
                                        } else if ('/' == cal[1]) {
                                            result = num[0] / (num[1] / num[2]);
                                        }
                                    } else if ('+' == cal[0]) {
                                        if ('+' == cal[1]) {
                                            result = num[0] + (num[1] + num[2]);
                                        } else if ('-' == cal[1]) {
                                            result = num[0] + (num[1] - num[2]);
                                        } else if ('*' == cal[1]) {
                                            result = num[0] + (num[1] * num[2]);
                                        } else if ('/' == cal[1]) {
                                            result = num[0] + (num[1] / num[2]);
                                        }
                                    } else if ('-' == cal[0]) {
                                        if ('+' == cal[1]) {
                                            result = num[0] - (num[1] + num[2]);
                                        } else if ('-' == cal[1]) {
                                            result = num[0] - (num[1] - num[2]);
                                        } else if ('*' == cal[1]) {
                                            result = num[0] - num[1] * num[2];
                                        } else if ('/' == cal[1]) {
                                            result = num[0] - num[1] / num[2];
                                        }
                                        System.out.printf("%s=%.2f", args[0], result);
                                    }

                                }
                        }
                    }

                    break;
                case ')':

                    break;
                default:
                    num[nums] = Double.parseDouble(args[i]);
                    nums++;
                    if (i == n - 1) {
                        for (i = 0; i < n; i++) {
                            //System.out.print(args[0].charAt(i));
                            switch (args[0].charAt(i)) {
                                case '+':
                                    cal = strNumber.toCharArray();
                                    cals++;
                                    break;
                                case '-':
                                    cal = strNumber.toCharArray();
                                    cals++;
                                    break;
                                case '*':
                                    cal = strNumber.toCharArray();
                                    cals++;
                                    break;
                                case '/':
                                    cal = strNumber.toCharArray();
                                    cals++;
                                    break;
                                case '(':

                                    break;
                                case ')':

                                    break;
                                default:
                                    num[nums] = Double.parseDouble(args[i]);
                                    nums++;
                                    break;
                            }
                            if ('*' == cal[0]) {
                                if ('+' == cal[1]) {
                                    result = num[0] * num[1] + num[2];
                                } else if ('-' == cal[1]) {
                                    result = num[0] * num[1] - num[2];
                                } else if ('*' == cal[1]) {
                                    result = num[0] * num[1] * num[2];
                                } else if ('/' == cal[1]) {
                                    result = num[0] * num[1] / num[2];
                                }
                            } else if ('/' == cal[0]) {
                                if ('+' == cal[1]) {
                                    result = num[0] / num[1] + num[2];
                                } else if ('-' == cal[1]) {
                                    result = num[0] / num[1] - num[2];
                                } else if ('*' == cal[1]) {
                                    result = (num[0] / num[1]) * num[2];
                                } else if ('/' == cal[1]) {
                                    result = (num[0] / num[1]) / num[2];
                                }
                            } else if ('+' == cal[0]) {
                                if ('+' == cal[1]) {
                                    result = num[0] + num[1] + num[2];
                                } else if ('-' == cal[1]) {
                                    result = num[0] + num[1] - num[2];
                                } else if ('*' == cal[1]) {
                                    result = num[0] + num[1] * num[2];
                                } else if ('/' == cal[1]) {
                                    result = num[0] + num[1] / num[2];
                                }
                            } else if ('-' == cal[0]) {
                                if ('+' == cal[1]) {
                                    result = num[0] - num[1] + num[2];
                                } else if ('-' == cal[1]) {
                                    result = num[0] - num[1] - num[2];
                                } else if ('*' == cal[1]) {
                                    result = num[0] - num[1] * num[2];
                                } else if ('/' == cal[1]) {
                                    result = num[0] - num[1] / num[2];
                                }
                            }
                        }
                        System.out.printf("%s=%.2f", args[0], result);
                    }

                    break;
            }
            //System.out.print(nums+","+cals);
        }
    }
}

