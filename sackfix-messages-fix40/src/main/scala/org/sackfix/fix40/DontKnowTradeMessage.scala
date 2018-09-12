package org.sackfix.fix40

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX40.xml
  */
case class DontKnowTradeMessage(orderIDField:Option[OrderIDField]=None,
                                execIDIntField:Option[ExecIDIntField]=None,
                                dKReasonField:DKReasonField,
                                symbolField:SymbolField,
                                sideField:SideField,
                                orderQtyIntField:OrderQtyIntField,
                                lastSharesIntField:LastSharesIntField,
                                lastPxField:LastPxField,
                                textField:Option[TextField]=None) extends SfFixMessageBody("Q")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    orderIDField.foreach(fmt(b,_))
    execIDIntField.foreach(fmt(b,_))
    fmt(b,dKReasonField)
    fmt(b,symbolField)
    fmt(b,sideField)
    fmt(b,orderQtyIntField)
    fmt(b,lastSharesIntField)
    fmt(b,lastPxField)
    textField.foreach(fmt(b,_))
    b
  }

}
     
object DontKnowTradeMessage extends SfFixMessageDecoder {
  val MsgType="Q"
  val MsgName="DontKnowTrade"
             
  override val MandatoryFields = HashSet[Int](
    DKReasonField.TagId, SymbolField.TagId, SideField.TagId, OrderQtyIntField.TagId, LastSharesIntField.TagId, 
    LastPxField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    OrderIDField.TagId, ExecIDIntField.TagId, TextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==OrderIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(DontKnowTradeMessage(myFields.get(OrderIDField.TagId).flatMap(f=>OrderIDField.decode(f)),
        myFields.get(ExecIDIntField.TagId).flatMap(f=>ExecIDIntField.decode(f)),
        DKReasonField.decode(myFields.get(DKReasonField.TagId)).get,
        SymbolField.decode(myFields.get(SymbolField.TagId)).get,
        SideField.decode(myFields.get(SideField.TagId)).get,
        OrderQtyIntField.decode(myFields.get(OrderQtyIntField.TagId)).get,
        LastSharesIntField.decode(myFields.get(LastSharesIntField.TagId)).get,
        LastPxField.decode(myFields.get(LastPxField.TagId)).get,
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f))))
    } else None
  }

    
}
     