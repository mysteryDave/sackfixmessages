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
case class OrderCancelRequestMessage(origClOrdIDField:OrigClOrdIDField,
                                     orderIDField:Option[OrderIDField]=None,
                                     clOrdIDField:ClOrdIDField,
                                     listIDField:Option[ListIDField]=None,
                                     cxlTypeField:CxlTypeField,
                                     clientIDField:Option[ClientIDField]=None,
                                     execBrokerField:Option[ExecBrokerField]=None,
                                     symbolField:SymbolField,
                                     symbolSfxField:Option[SymbolSfxField]=None,
                                     securityIDField:Option[SecurityIDField]=None,
                                     iDSourceField:Option[IDSourceField]=None,
                                     issuerField:Option[IssuerField]=None,
                                     securityDescField:Option[SecurityDescField]=None,
                                     sideField:SideField,
                                     orderQtyIntField:OrderQtyIntField,
                                     textField:Option[TextField]=None) extends SfFixMessageBody("F")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,origClOrdIDField)
    orderIDField.foreach(fmt(b,_))
    fmt(b,clOrdIDField)
    listIDField.foreach(fmt(b,_))
    fmt(b,cxlTypeField)
    clientIDField.foreach(fmt(b,_))
    execBrokerField.foreach(fmt(b,_))
    fmt(b,symbolField)
    symbolSfxField.foreach(fmt(b,_))
    securityIDField.foreach(fmt(b,_))
    iDSourceField.foreach(fmt(b,_))
    issuerField.foreach(fmt(b,_))
    securityDescField.foreach(fmt(b,_))
    fmt(b,sideField)
    fmt(b,orderQtyIntField)
    textField.foreach(fmt(b,_))
    b
  }

}
     
object OrderCancelRequestMessage extends SfFixMessageDecoder {
  val MsgType="F"
  val MsgName="OrderCancelRequest"
             
  override val MandatoryFields = HashSet[Int](
    OrigClOrdIDField.TagId, ClOrdIDField.TagId, CxlTypeField.TagId, SymbolField.TagId, SideField.TagId, 
    OrderQtyIntField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    OrderIDField.TagId, ListIDField.TagId, ClientIDField.TagId, ExecBrokerField.TagId, SymbolSfxField.TagId, 
    SecurityIDField.TagId, IDSourceField.TagId, IssuerField.TagId, SecurityDescField.TagId, TextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==OrigClOrdIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(OrderCancelRequestMessage(OrigClOrdIDField.decode(myFields.get(OrigClOrdIDField.TagId)).get,
        myFields.get(OrderIDField.TagId).flatMap(f=>OrderIDField.decode(f)),
        ClOrdIDField.decode(myFields.get(ClOrdIDField.TagId)).get,
        myFields.get(ListIDField.TagId).flatMap(f=>ListIDField.decode(f)),
        CxlTypeField.decode(myFields.get(CxlTypeField.TagId)).get,
        myFields.get(ClientIDField.TagId).flatMap(f=>ClientIDField.decode(f)),
        myFields.get(ExecBrokerField.TagId).flatMap(f=>ExecBrokerField.decode(f)),
        SymbolField.decode(myFields.get(SymbolField.TagId)).get,
        myFields.get(SymbolSfxField.TagId).flatMap(f=>SymbolSfxField.decode(f)),
        myFields.get(SecurityIDField.TagId).flatMap(f=>SecurityIDField.decode(f)),
        myFields.get(IDSourceField.TagId).flatMap(f=>IDSourceField.decode(f)),
        myFields.get(IssuerField.TagId).flatMap(f=>IssuerField.decode(f)),
        myFields.get(SecurityDescField.TagId).flatMap(f=>SecurityDescField.decode(f)),
        SideField.decode(myFields.get(SideField.TagId)).get,
        OrderQtyIntField.decode(myFields.get(OrderQtyIntField.TagId)).get,
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f))))
    } else None
  }

    
}
     