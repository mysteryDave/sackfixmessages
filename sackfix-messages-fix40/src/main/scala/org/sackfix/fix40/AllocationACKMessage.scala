package org.sackfix.fix40

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX40.xml
  */
case class AllocationACKMessage(clientIDField:Option[ClientIDField]=None,
                                execBrokerField:Option[ExecBrokerField]=None,
                                allocIDIntField:AllocIDIntField,
                                tradeDateField:TradeDateField,
                                transactTimeField:Option[TransactTimeField]=None,
                                allocStatusField:AllocStatusField,
                                allocRejCodeField:Option[AllocRejCodeField]=None,
                                textField:Option[TextField]=None) extends SfFixMessageBody("P")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    clientIDField.foreach(fmt(b,_))
    execBrokerField.foreach(fmt(b,_))
    fmt(b,allocIDIntField)
    fmt(b,tradeDateField)
    transactTimeField.foreach(fmt(b,_))
    fmt(b,allocStatusField)
    allocRejCodeField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    b
  }

}
     
object AllocationACKMessage extends SfFixMessageDecoder {
  val MsgType="P"
  val MsgName="AllocationACK"
             
  override val MandatoryFields = HashSet[Int](
    AllocIDIntField.TagId, TradeDateField.TagId, AllocStatusField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    ClientIDField.TagId, ExecBrokerField.TagId, TransactTimeField.TagId, AllocRejCodeField.TagId, TextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==ClientIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(AllocationACKMessage(myFields.get(ClientIDField.TagId).flatMap(f=>ClientIDField.decode(f)),
        myFields.get(ExecBrokerField.TagId).flatMap(f=>ExecBrokerField.decode(f)),
        AllocIDIntField.decode(myFields.get(AllocIDIntField.TagId)).get,
        TradeDateField.decode(myFields.get(TradeDateField.TagId)).get,
        myFields.get(TransactTimeField.TagId).flatMap(f=>TransactTimeField.decode(f)),
        AllocStatusField.decode(myFields.get(AllocStatusField.TagId)).get,
        myFields.get(AllocRejCodeField.TagId).flatMap(f=>AllocRejCodeField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f))))
    } else None
  }

    
}
     